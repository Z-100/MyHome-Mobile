package com.myhome.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Object success handler
 */
public interface ApiObjectSuccessHandler {
    void handle(JSONObject result) throws JSONException;
}
