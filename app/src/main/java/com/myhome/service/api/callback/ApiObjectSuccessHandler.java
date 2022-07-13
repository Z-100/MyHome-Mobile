package com.myhome.service.api.callback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Object success handler
 */
@Deprecated
public interface ApiObjectSuccessHandler {
    void handle(JSONObject result) throws JSONException;
}
