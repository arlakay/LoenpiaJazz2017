package com.e_er_de.jazzngisoringin2017.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ILM on 6/29/2016.
 */
public class RestApi {

    public static final String BASE_URL = "http://ersarizkidimitri.ga/erd_jazz/api/";  //Debugging
//    public static final String BASE_URL = "http://192.168.0.101/api/erd_jazz/index.php/api/";        //Local Debugging

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
