package com.example.hodaco.graduationproj_login.Model;

import android.util.Log;

import com.example.hodaco.graduationproj_login.Contract.Login_Contract;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote.ApiUtils;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote.Service;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostReq;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hoda.CO on 08/04/2018.
 */

public class Login_Model implements Login_Contract.model{
   boolean result;
    @Override
    public boolean check(String email, String password) {
        Service ApiService = ApiUtils.getService();
        PostReq user = new PostReq();
        user.setEmail(email);
        user.setPassword(password);
        ApiService.Login(user).enqueue(new Callback<PostRes>() {
            @Override
            public void onResponse(Call<PostRes> call, Response<PostRes> response) {
                result=true;
                Log.i("hoda","hiiiii");
            }
            @Override
            public void onFailure(Call<PostRes> call, Throwable t) {
                Log.i("hoda","noooooooo");
              result =false;
            }
        });
        return result;
    }
}
