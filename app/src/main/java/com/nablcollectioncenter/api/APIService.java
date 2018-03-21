package com.nablcollectioncenter.api;

import com.nablcollectioncenter.pojo.LabResponse;
import com.nablcollectioncenter.pojo.LoginRequest;
import com.nablcollectioncenter.pojo.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by raj on 3/16/2018.
 */

public interface APIService {

    @POST("tokens")
    Call<LoginResponse> loginrequest(@Header("Content-Type") String Content_Type,@Body LoginRequest request);

    @GET("labs")
    Call<LabResponse> labrequest(@Header("Content-Type") String Content_Type, @Header("Authorization") String Authorization);
}
