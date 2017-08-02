package com.ramadan.webyrtclib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Mahmoud.Ramadan on 8/2/2017.
 */

/**
 * this class will used to create local and remote views for caller and callee
 */
public class WebyRTCPercentFrameLayout extends ViewGroup {

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
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }


}
