package com.akash.authentication_retro.Api;

import com.akash.authentication_retro.Model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

@FormUrlEncoded
    @POST("registrationapi.php?apical=signup")
    Call<User> registeruser(
      @Field("username") String username,
      @Field("password") String password,
      @Field("email") String email,
      @Field("gender") String gender



    );


    @FormUrlEncoded
    @POST("registrationapi.php?apical=login")
    Call<User> loginuser(

            @Field("username") String username,
            @Field("password") String password


    );







}
