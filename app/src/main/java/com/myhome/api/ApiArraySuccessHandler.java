package com.myhome.api;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * handler for sucessful response of type array
 */
public interface ApiArraySuccessHandler {
    void handle(JSONArray result) throws JSONException;
}
