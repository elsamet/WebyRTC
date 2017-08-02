package com.ramadan.webyrtclib;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mahmoud.Ramadan on 8/2/2017.
 */

public class WebyRTCCallScreen extends FrameLayout {

    private WebyRTCPercentFrameLayout localRenderLayout, remoteRenderLayout;
    private WebyRtCCallControls controls;
    private WebyRTCIncomingCallOverlay incomingCallOverlay;
    private FloatingActionButton endCallButton;
    private TextView elapsedTime, phoneNumber, name, label, status;
    private ImageView photo;

    public WebyRTCCallScreen(Context context) {
        super(context);
        initialize();
    }

    public WebyRTCCallScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public WebyRTCCallScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }


    private void initialize() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.webyrtc_call_screen, this, true);

        this.elapsedTime = (TextView) findViewById(R.id.elapsedTime);
        this.photo = (ImageView) findViewById(R.id.photo);
        this.localRenderLayout = (WebyRTCPercentFrameLayout) findViewById(R.id.local_render_layout);
        this.remoteRenderLayout = (WebyRTCPercentFrameLayout) findViewById(R.id.remote_render_layout);
        this.phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        this.name = (TextView) findViewById(R.id.name);
        this.label = (TextView) findViewById(R.id.label);
        this.status = (TextView) findViewById(R.id.callStateLabel);
        this.controls = (WebyRtCCallControls) findViewById(R.id.inCallControls);
        this.endCallButton = (FloatingActionButton) findViewById(R.id.hangup_fab);
        //this.incomingCallOverlay = (WebyRTCIncomingCallOverlay) findViewById(R.id.callControls);
//        this.untrustedIdentityContainer   = findViewById(R.id.untrusted_layout);
//        this.untrustedIdentityExplanation = (TextView) findViewById(R.id.untrusted_explanation);
//        this.acceptIdentityButton         = (Button)findViewById(R.id.accept_safety_numbers);
//        this.cancelIdentityButton         = (Button)findViewById(R.id.cancel_safety_numbers);
//        this.expandedInfo                 = (RelativeLayout)findViewById(R.id.expanded_info);
//        this.callHeader                   = (ViewGroup)findViewById(R.id.call_info_1);

//        this.localRenderLayout.setHidden(true);
//        this.remoteRenderLayout.setHidden(true);
//        this.minimized = false;
//
//        this.remoteRenderLayout.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setMinimized(!minimized);
//            }
//        });
    }

}
