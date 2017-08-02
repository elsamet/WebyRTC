package com.ramadan.webyrtclib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mahmoud.Ramadan on 8/2/2017.
 */

/**
 * this class will used to create local and remote views for caller and callee
 */
public class WebyRTCPercentFrameLayout extends ViewGroup {

    private int xPercent = 0;
    private int yPercent = 0;
    private int widthPercent = 100;
    private int heightPercent = 100;

    private boolean square = false;
    private boolean hidden = false;

    public WebyRTCPercentFrameLayout(Context context) {
        super(context);
    }

    public WebyRTCPercentFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WebyRTCPercentFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int width = getDefaultSize(Integer.MAX_VALUE, widthMeasureSpec);
        final int height = getDefaultSize(Integer.MAX_VALUE, heightMeasureSpec);

        setMeasuredDimension(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));

        int childWidth = width * widthPercent / 100;
        int childHeight = height * heightPercent / 100;

        if (square) {
            if (width > height) childWidth = childHeight;
            else childHeight = childWidth;
        }

        if (hidden) {
            childWidth = 1;
            childHeight = 1;
        }

        int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST);
        int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);

        for (int i = 0; i < getChildCount(); ++i) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int width = right - left;
        final int height = bottom - top;
        // Sub-rectangle specified by percentage values.
        final int subWidth = width * widthPercent / 100;
        final int subHeight = height * heightPercent / 100;
        final int subLeft = left + width * xPercent / 100;
        final int subTop = top + height * yPercent / 100;

        for (int i = 0; i < getChildCount(); ++i) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                // Center child both vertically and horizontally.
                int childLeft = subLeft + (subWidth - childWidth) / 2;
                int childTop = subTop + (subHeight - childHeight) / 2;

                if (hidden) {
                    childLeft = 0;
                    childTop = 0;
                }

                child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
            }
        }
    }

    public void setSquare(boolean square) {
        this.square = square;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setPosition(int xPercent, int yPercent, int widthPercent, int heightPercent) {
        this.xPercent = xPercent;
        this.yPercent = yPercent;
        this.widthPercent = widthPercent;
        this.heightPercent = heightPercent;
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
