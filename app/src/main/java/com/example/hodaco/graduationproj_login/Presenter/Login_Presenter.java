package com.example.hodaco.graduationproj_login.Presenter;

import android.util.Log;
import android.view.View;

import com.example.hodaco.graduationproj_login.Contract.Login_Contract;
import com.example.hodaco.graduationproj_login.Model.Login_Model;

/**
 * Created by hoda.CO on 08/04/2018.
 */

public class Login_Presenter  implements Login_Contract.presenter{
    private Login_Contract.model pmodel;
    private Login_Contract.view pview;

    public Login_Presenter(Login_Contract.view view) {
        this.pview = view;
        initPresenter();
    }
    void initPresenter()
    {
        pmodel=new Login_Model(this);
        pview.initView();
    }

    @Override
    public void onClick(View view) {
        pmodel.check(pview.getEmail().toString(),pview.getPassword().toString());
        Log.i("hoda","presenter");

    }
    @Override
    public void res(boolean b) {
        if (b==true) {
            pview.success();
        }
        else
        {
            pview.failure();
        }
    }
}
