package com.ramadan.webyrtclib.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.ramadan.webyrtclib.R;

/**
 * Created by Mahmoud.Ramadan on 8/2/2017.
 */

public class WebyRtCCallControls extends LinearLayout {

    private CompoundButton audioMuteButton;
    private CompoundButton videoMuteButton;
    private CompoundButton speakerButton;
    private CompoundButton bluetoothButton;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WebyRtCCallControls(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public WebyRtCCallControls(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public WebyRtCCallControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public WebyRtCCallControls(Context context) {
        super(context);
        initialize();
    }

    private void initialize() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.webyrtc_call_controls, this, true);
//
//        this.speakerButton   = ViewUtil.findById(this, R.id.speakerButton);
//        this.bluetoothButton = ViewUtil.findById(this, R.id.bluetoothButton);
//        this.audioMuteButton = ViewUtil.findById(this, R.id.muteButton);
//        this.videoMuteButton = ViewUtil.findById(this, R.id.video_mute_button);
    }

    public void setAudioMuteButtonListener(final MuteButtonListener listener) {
        audioMuteButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                listener.onToggle(b);
            }
        });
    }

    public void setVideoMuteButtonListener(final MuteButtonListener listener) {
        videoMuteButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.onToggle(!isChecked);
            }
        });
    }

//    public void setSpeakerButtonListener(final SpeakerButtonListener listener) {
//        speakerButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                listener.onSpeakerChange(isChecked);
//                updateAudioState(bluetoothButton.getVisibility() == View.VISIBLE);
//            }
//        });
//    }
//
//    public void setBluetoothButtonListener(final BluetoothButtonListener listener) {
//        bluetoothButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                listener.onBluetoothChange(isChecked);
//                updateAudioState(true);
//            }
//        });
//    }

//    public void updateAudioState(boolean isBluetoothAvailable) {
//      // AudioManager audioManager = ServiceUtil.getAudioManager(getContext());
//
//        if (!isBluetoothAvailable) {
//            bluetoothButton.setVisibility(View.GONE);
//        } else {
//            bluetoothButton.setVisibility(View.VISIBLE);
//        }
//
//        if (audioManager.isBluetoothScoOn()) {
//            bluetoothButton.setChecked(true);
//            speakerButton.setChecked(false);
//        } else if (audioManager.isSpeakerphoneOn()) {
//            speakerButton.setChecked(true);
//            bluetoothButton.setChecked(false);
//        } else {
//            speakerButton.setChecked(false);
//            bluetoothButton.setChecked(false);
//        }
//    }

    public boolean isVideoEnabled() {
        return videoMuteButton.isChecked();
    }

    public void setVideoEnabled(boolean enabled) {
        videoMuteButton.setChecked(enabled);
    }

    public void setMicrophoneEnabled(boolean enabled) {
        audioMuteButton.setChecked(!enabled);
    }

    public void setControlsEnabled(boolean enabled) {
        if (enabled && Build.VERSION.SDK_INT >= 11) {
            speakerButton.setAlpha(1.0f);
            bluetoothButton.setAlpha(1.0f);
            videoMuteButton.setAlpha(1.0f);
            audioMuteButton.setAlpha(1.0f);

            speakerButton.setEnabled(true);
            bluetoothButton.setEnabled(true);
            videoMuteButton.setEnabled(true);
            audioMuteButton.setEnabled(true);
        } else if (!enabled && Build.VERSION.SDK_INT >= 11) {
            speakerButton.setAlpha(0.3f);
            bluetoothButton.setAlpha(0.3f);
            videoMuteButton.setAlpha(0.3f);
            audioMuteButton.setAlpha(0.3f);

            speakerButton.setChecked(false);
            bluetoothButton.setChecked(false);
            videoMuteButton.setChecked(false);
            audioMuteButton.setChecked(false);

            speakerButton.setEnabled(false);
            bluetoothButton.setEnabled(false);
            videoMuteButton.setEnabled(false);
            audioMuteButton.setEnabled(false);
        }
    }

//    public void displayVideoTooltip(ViewGroup viewGroup) {
//        if (Build.VERSION.SDK_INT > 15) {
//            final ToolTipsManager toolTipsManager = new ToolTipsManager();
//
//            ToolTip toolTip = new ToolTip.Builder(getContext(), videoMuteButton, viewGroup,
//                    getContext().getString(R.string.WebRtcCallControls_tap_to_enable_your_video),
//                    ToolTip.POSITION_BELOW).build();
//            toolTipsManager.show(toolTip);
//
//            videoMuteButton.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    toolTipsManager.findAndDismiss(videoMuteButton);
//                }
//            }, 4000);
//        }
//    }

    public void reset() {
        audioMuteButton.setChecked(false);
        videoMuteButton.setChecked(false);
        speakerButton.setChecked(false);
        bluetoothButton.setChecked(false);
        bluetoothButton.setVisibility(View.GONE);
    }

    public static interface MuteButtonListener {
        public void onToggle(boolean isMuted);
    }

    public static interface SpeakerButtonListener {
        public void onSpeakerChange(boolean isSpeaker);
    }

    public static interface BluetoothButtonListener {
        public void onBluetoothChange(boolean isBluetooth);
    }





}

