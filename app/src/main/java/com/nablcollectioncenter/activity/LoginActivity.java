package com.nablcollectioncenter.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nablcollectioncenter.MainActivity;
import com.nablcollectioncenter.R;
import com.nablcollectioncenter.api.APIService;
import com.nablcollectioncenter.api.ApiUtils;
import com.nablcollectioncenter.pojo.LoginRequest;
import com.nablcollectioncenter.pojo.LoginResponse;
import com.nablcollectioncenter.util.AppDialog;
import com.nablcollectioncenter.util.ConnectionDetector;
import com.nablcollectioncenter.util.AppConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by raj on 3/16/2018.
 */

public class LoginActivity extends BaseActivity {

    private APIService mAPIService;
    private Button btn_login;
    private EditText login_userName,login_password;
    // flag for Internet connection status
    Boolean isInternetPresent = false;
    // Connection detector class
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_userName = (EditText) findViewById(R.id.login_userName);
        login_password = (EditText) findViewById(R.id.login_password);

        btn_login = (Button) findViewById(R.id.btn_login);

        mAPIService = ApiUtils.getAPIService();

        cd = new ConnectionDetector(getApplicationContext());
        // get Internet status
        isInternetPresent = cd.isConnectingToInternet();

        login_userName.setText("9899915051");
        login_password.setText("asimov78");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isInternetPresent = cd.isConnectingToInternet();

                if (isInternetPresent){
                    LoginApi();
                } else {
                    Toast.makeText(LoginActivity.this, AppConstant.NO_INTERNET_CONNECTED,Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void LoginApi(){
        LoginRequest request = new LoginRequest();
        request.setUserName(login_userName.getText().toString());
        request.setPassword(login_password.getText().toString());
        request.setGrant_type("password");

        final ProgressDialog d = AppDialog.showLoading(LoginActivity.this);
        d.setCanceledOnTouchOutside(false);


        mAPIService.loginrequest("application/json", request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                System.out.println("xxx sucessfully");

                d.dismiss();

                if (response.body() != null){
                    if (response.body().getMessage().equalsIgnoreCase("successfully login")){

                        saveIntoPrefs(AppConstant.accessToken,response.body().getAccessToken());

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,R.string.error_occured,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println("xxx failer");

                d.dismiss();
            }
        });

    }
}
