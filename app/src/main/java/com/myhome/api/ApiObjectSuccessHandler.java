package com.myhome.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * handler for sucessful response of type object
 */
public interface ApiObjectSuccessHandler {
    void handle(JSONObject result) throws JSONException;
}
