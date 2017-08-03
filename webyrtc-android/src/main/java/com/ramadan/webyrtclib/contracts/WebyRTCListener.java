package com.ramadan.webyrtclib.contracts;

import org.webrtc.MediaStream;

/**
 * Created by Mahmoud.Ramadan on 8/3/2017.
 */

public interface WebyRTCListener {

    void onCallReady(String callId);

    void onStatusChanged(String newStatus);

    void onLocalStream(MediaStream localStream);

    void onAddRemoteStream(MediaStream remoteStream, int endPoint);

    void onRemoveRemoteStream(int endPoint);

}
