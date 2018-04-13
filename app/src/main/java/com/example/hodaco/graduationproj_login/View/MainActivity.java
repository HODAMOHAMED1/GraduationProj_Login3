package com.example.hodaco.graduationproj_login.View;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.hodaco.graduationproj_login.Contract.Login_Contract;
import com.example.hodaco.graduationproj_login.Presenter.Login_Presenter;
import com.example.hodaco.graduationproj_login.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Login_Contract.view {
    Login_Contract.presenter presenter;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.button)
    Button login;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isConnect(MainActivity.this)) buildDialog(MainActivity.this).show();
        else {
            ButterKnife.bind(this);
            presenter = new Login_Presenter(this);
        }
    }

    @Override
    public void initView() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.password, ".+", R.string.passworderror);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {
                    presenter.onClick(view);
                }
            }
        });
    }
    @Override
    public String getEmail() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void result(boolean b) {
        if (b == true) {
            Log.i("hoda","true");
            Toast.makeText(MainActivity.this, "onsuccress" + getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
        } else {
            Log.i("hoda","false");
            Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean isConnect (Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else
                return false;
        } else
            return false;
    }
    public AlertDialog.Builder buildDialog(Context c)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this.press ok to Exit");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        return builder;
    }
}