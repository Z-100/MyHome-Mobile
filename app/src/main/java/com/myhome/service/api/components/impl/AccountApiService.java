package com.myhome.service.api.components.impl;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.myhome.service.api.callback.ApiArraySuccessHandler;
import com.myhome.service.api.callback.ApiObjectSuccessHandler;
import com.myhome.other.Api;
import com.myhome.other.ApiError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rad14nt
 */
@Deprecated
public class AccountApiService {

    private static final Map<String, String> header = new HashMap<>();

    public void getLoginToken(Context context, String email, String password, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, Api.BASE_URL + "account/login", data,
                response -> {
                    Log.d(Api.TAG, response.toString());
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR + error, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.PASSWORD_FIELD, password);
                params.put(Api.TOKEN_FIELD, Api.REGISTRATION_TOKEN);
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
                Api.BASE_URL + "account/register",
                data,
                response -> {
                    Log.d(Api.TAG, response.toString());
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.PASSWORD_FIELD, password);
                params.put(Api.NEW_HOUSE_FIELD, Api.DEFAULT_HOME_NAME);
                params.put(Api.DEFAULT_MEMBER_FIELD, defaultMemberName);
                params.put(Api.TOKEN_FIELD, Api.LOGIN_TOKEN);
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
                Api.BASE_URL + "member/get-member",
                data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.TOKEN_FIELD, token);

                return params;
            }
        };
        queue.add(request);
    }

    public void removeMember(Context context, String email, String token, String memberid, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, Api.BASE_URL + "member/delete-member", data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.TOKEN_FIELD, token);
                params.put(Api.MEMBER_ID_FIELD, memberid);

                return params;
            }
        };
        queue.add(request);
    }

    public void insertMember(Context context, String email, String token, String name, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, Api.BASE_URL + "member/insert-member", data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.TOKEN_FIELD, token);
                params.put(Api.ICON_FIELD, Api.DEFAULT_ICON);
                params.put(Api.NAME_FIELD, name);
                return params;
            }
        };
        queue.add(request);
    }

    public void updateMember(Context context, String email, String token, String member_id, String replacement_icon, String replacement_name, ApiObjectSuccessHandler callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject data = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, Api.BASE_URL + "member/update-member", data,
                response -> {
                    try {
                        callback.handle(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Log.d(Api.TAG, error.toString());
            Toast.makeText(context, ApiError.GENERAL_ERROR, Toast.LENGTH_LONG).show();
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put(Api.EMAIL_FIELD, email);
                params.put(Api.TOKEN_FIELD, token);
                params.put(Api.MEMBER_ID_FIELD, member_id);
                params.put(Api.REPLACEMENT_ICON_FIELD, replacement_icon);
                params.put(Api.REPLACEMENT_NAME_FIELD, replacement_name);
                return params;
            }
        };
        queue.add(request);
    }

    public void resetPassword() {
        // Was isch das?
    }
}
