package com.example.hodaco.graduationproj_login.LoginDataCheck.UserResp.Remote;

/**
 * Created by hoda.CO on 09/04/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://192.168.1.4:8084/MedicalInsuranceSystem/api/version1/user/";

    public static Service getService() {

        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
