package com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote;

import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostReq;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hoda.CO on 09/04/2018.
 */

public interface Service {
    @POST("login")
    Call<PostRes> Login (@Body PostReq req);
}
