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
    private Login_Contract.presenter presenter;
    public Login_Model( Login_Contract.presenter pres) {
        this.presenter=pres;
    }

    boolean result;
    @Override
    public void check(String email, String password) {
        Service ApiService = ApiUtils.getService();
        PostReq user = new PostReq();
        user.setEmail(email);
        user.setPassword(password);

        ApiService.Login(user).enqueue(new Callback<PostRes>() {
            @Override
            public void onResponse(Call<PostRes> call, Response<PostRes> response) {
                result=true;
                presenter.res(result);
                Log.i("hoda","hiiiii");
            }
            @Override
            public void onFailure(Call<PostRes> call, Throwable t) {
                Log.i("hoda","noooooooo");
              result =false;
                presenter.res(result);
            }
        });
    }
}
