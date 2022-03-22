package com.myhome.api;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Object success handler
 */
public interface ApiArraySuccessHandler {
    void handle(JSONArray result) throws JSONException;
}
