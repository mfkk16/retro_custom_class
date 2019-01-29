package com.example.calsys.retro_custom_class.Retro;

import com.example.calsys.retro_custom_class.Retro.Response.Tutorsubjectlistresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIinterface {

   // @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("tutors?")
    Call<Tutorsubjectlistresponse> get_tutors(@Query("id") String sub_id, @Query("cat") String cat);

}
