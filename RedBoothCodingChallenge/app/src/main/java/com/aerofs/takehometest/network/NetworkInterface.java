package com.aerofs.takehometest.network;

import com.aerofs.takehometest.network.pojo.Repo;
import com.aerofs.takehometest.network.pojo.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkInterface {

    // Fetch User Details
    @GET("users/{username}")
    Call<User> fetchUserDetails(@Path("username") String username);

    // Fetch Repo Details for user
    @GET("users/{username}/repos")
    Call<ArrayList<Repo>> fetchUserRepoDetails(@Path("username") String username);

}
