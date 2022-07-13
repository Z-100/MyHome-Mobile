package com.myhome.service.api.callback;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Object success handler
 */
@Deprecated
public interface ApiArraySuccessHandler {
    void handle(JSONArray result) throws JSONException;
}
