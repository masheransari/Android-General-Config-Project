package com.dotinfiny.banglesystem.retrofit;


import android.util.Log;

import com.org.dotinfiny.gamesprime.helpers.KotlinHelper;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitBaseCallBack<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        try {

            if (response.isSuccessful()) {
                onResponse(response.body(), null);
            } else {
                String serverError = response.errorBody().string();
                Log.d("Server Error", "" + serverError);
                Error error = null;
                if (KotlinHelper.Companion.isJSONValid(serverError)) {
                    JSONObject errorObject = new JSONObject(serverError);
                    if (errorObject.has("error_description")) {
                        error = new Error(errorObject.getString("error_description"));
                    } else if (errorObject.has("Message")) {
                        error = new Error(errorObject.getString("Message"));
                    } else {
                        error = new Error(serverError);
                    }
                } else {
                    error = new Error(serverError);
                }

                onResponse(null, error);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error(e.getMessage());
            onResponse(null, error);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("RetrofitBase", "on Failure" + t.getMessage());
        Error error = new Error(t.getMessage());
        onResponse(null, error);
    }
    public abstract void onResponse(T response, Error error);
}
