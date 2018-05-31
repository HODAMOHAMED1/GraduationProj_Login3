package com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote;

import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostReq;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostRes;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by hoda.CO on 09/04/2018.
 */

public interface Service {
    @POST("login")
    @Headers("Content-Type:application/json")
    Call<PostRes> Login (@Body PostReq obj);
}
