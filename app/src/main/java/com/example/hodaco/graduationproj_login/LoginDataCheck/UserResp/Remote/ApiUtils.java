package com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote;

/**
 * Created by hoda.CO on 09/04/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://polls.apiblueprint.org/Tamini/";

    public static Service getService() {

        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
