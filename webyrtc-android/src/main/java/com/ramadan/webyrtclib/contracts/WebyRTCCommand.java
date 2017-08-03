package com.ramadan.webyrtclib.contracts;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mahmoud.Ramadan on 8/3/2017.
 */

public interface WebyRTCCommand {
    void execute(String peerId, JSONObject payload) throws JSONException;
}
