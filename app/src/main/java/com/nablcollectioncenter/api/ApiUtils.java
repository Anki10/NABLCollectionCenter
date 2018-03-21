package com.nablcollectioncenter.api;

/**
 * Created by raj on 3/16/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://34.233.105.174:5002/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
