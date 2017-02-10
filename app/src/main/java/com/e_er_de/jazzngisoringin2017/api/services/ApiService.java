package com.e_er_de.jazzngisoringin2017.api.services;

import com.e_er_de.jazzngisoringin2017.model.ArtistResponse;
import com.e_er_de.jazzngisoringin2017.model.ScheduleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ILM on 6/29/2016.
 */
public interface ApiService {

    //Schedule by Stage-
    @GET("Schedule/getAllScheduleByStage")
    Call<ScheduleResponse> getAllScheduleByStage(@Query("X-API-KEY") String api_key);

    //Schedule by Time -
    @GET("Schedule/getAllScheduleByTime")
    Call<ScheduleResponse> getAllScheduleByTime(@Query("X-API-KEY") String api_key);

    //Artist -
    @GET("schedule/getAllArtist")
    Call<ArtistResponse> getAllArtist(@Query("X-API-KEY") String api_key);

}
