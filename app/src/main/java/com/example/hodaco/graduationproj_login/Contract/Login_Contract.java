package com.example.hodaco.graduationproj_login.Contract;

import android.view.View;

/**
 * Created by hoda.CO on 08/04/2018.
 */

public interface Login_Contract {
    interface model
    {
        void check(String email,String Password);
    }
    interface view
    {
        void initView();
        String getEmail();
        String getPassword();
        void success();
        void failure();
    }
    interface presenter
    {
        void onClick(View view);
        void res (boolean b);
    }
}
