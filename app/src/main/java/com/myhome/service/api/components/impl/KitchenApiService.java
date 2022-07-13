package com.myhome.service.api.components.impl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.myhome.service.api.callback.ApiArraySuccessHandler;
import com.myhome.other.ApiConstants;
import com.myhome.other.ApiError;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rad14nt
 */
@Deprecated
public class KitchenApiService {

    public void getRecipe(Context context, String email, String token, ApiArraySuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONArray data = new JSONArray();

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, ApiConstants.BASE_URL + "recipe/get-recipes", data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(ApiConstants.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(ApiConstants.GET_RATING_FIELD, "1");
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.TOKEN_FIELD, token);
                return params;
            }
        };
        queue.add(request);
    }
}
