package com.myhome.api.impl;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.myhome.api.ApiArraySuccessHandler;
import com.myhome.api.ApiObjectSuccessHandler;
import com.myhome.other.ApiConstants;
import com.myhome.other.ApiError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rad14nt
 */
public class AccountApiService {

    private static final Map<String, String> header = new HashMap<>();

    public void getLoginToken(Context context, String email, String password, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, ApiConstants.BASE_URL + "account/login", data,
                response -> {
                    Log.d(ApiConstants.TAG, response.toString());
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Toast.makeText(context, ApiError.GENERAL_ERROR + error, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.PASSWORD_FIELD, password);
                params.put(ApiConstants.TOKEN_FIELD, ApiConstants.REGISTRATION_TOKEN);
                return params;
            }
        };
        queue.add(request);
    }

    public void registerNewAccount(Context context, String email, String password, String defaultMemberName, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                ApiConstants.BASE_URL + "account/register",
                data,
                response -> {
                    Log.d(ApiConstants.TAG, response.toString());
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
                }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.PASSWORD_FIELD, password);
                params.put(ApiConstants.NEW_HOUSE_FIELD, ApiConstants.DEFAULT_HOME_NAME);
                params.put(ApiConstants.DEFAULT_MEMBER_FIELD, defaultMemberName);
                params.put(ApiConstants.TOKEN_FIELD, ApiConstants.LOGIN_TOKEN);
                return params;
            }
        };
        queue.add(request);
    }

    public void getAllMembers(Context context, String email, String token, ApiArraySuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONArray data = new JSONArray();

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                ApiConstants.BASE_URL + "member/get-member",
                data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.TOKEN_FIELD, token);

                return params;
            }
        };
        queue.add(request);
    }

    public void removeMember(Context context, String email, String token, String memberid, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, ApiConstants.BASE_URL + "member/delete-member", data,
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
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.TOKEN_FIELD, token);
                params.put(ApiConstants.MEMBER_ID_FIELD, memberid);

                return params;
            }
        };
        queue.add(request);
    }

    public void insertMember(Context context, String email, String token, String name, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, ApiConstants.BASE_URL + "member/insert-member", data,
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
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.TOKEN_FIELD, token);
                params.put(ApiConstants.ICON_FIELD, ApiConstants.DEFAULT_ICON);
                params.put(ApiConstants.NAME_FIELD, name);
                return params;
            }
        };
        queue.add(request);
    }

    public void updateMember(Context context, String email, String token, String member_id, String replacement_icon, String replacement_name, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, ApiConstants.BASE_URL + "member/update-member", data,
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
                params.put(ApiConstants.EMAIL_FIELD, email);
                params.put(ApiConstants.TOKEN_FIELD, token);
                params.put(ApiConstants.MEMBER_ID_FIELD, member_id);
                params.put(ApiConstants.REPLACEMENT_ICON_FIELD, replacement_icon);
                params.put(ApiConstants.REPLACEMENT_NAME_FIELD, replacement_name);
                return params;
            }
        };
        queue.add(request);
    }

    public void resetPassword() {
        // Was isch das?
    }
}
