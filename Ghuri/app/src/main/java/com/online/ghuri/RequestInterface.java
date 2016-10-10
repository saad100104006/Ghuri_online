package com.online.ghuri;

/**
 * Created by saad on 10/5/16.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}