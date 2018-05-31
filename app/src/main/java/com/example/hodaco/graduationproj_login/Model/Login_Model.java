package com.example.hodaco.graduationproj_login.Model;

import android.util.Log;

import com.example.hodaco.graduationproj_login.Contract.Login_Contract;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote.ApiUtils;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote.Service;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostReq;
import com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.UserRes.PostRes;

import org.json.JSONException;
import org.json.JSONObject;

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
        PostReq req = new PostReq();
        req.setEmail(email);
        req.setPassword(password);
        ApiService.Login(req).enqueue(new Callback<PostRes>() {
            @Override
            public void onResponse(Call<PostRes> call, Response<PostRes> response) {
                result=true;
                Log.i("resulttttt",response.body().getMessage());
                Log.i("resultttttn","id="+ String.valueOf(response.body().getId()));
                presenter.res(result);
                Log.i("hoda","hiiiii");
            }
            @Override
            public void onFailure(Call<PostRes> call, Throwable t) {
                Log.i("hoda","noooooooo");
              result =false;
                System.out.print(t.getMessage());
                System.out.print(call.request().body());
                presenter.res(result);
            }
        });
    }
}
