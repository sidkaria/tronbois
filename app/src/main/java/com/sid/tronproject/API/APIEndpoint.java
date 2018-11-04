package com.sid.tronproject.API;

import com.sid.tronproject.Responses.TransactionResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIEndpoint {

    @GET("transactions")
    Call<ArrayList<TransactionResponse>> getTransactions(@Query("address") String account_address);

    @GET("balance")
    Call<String> getBalance(@Query("address") String account_address);

    @GET("address")
    Call<String> getAddress(@Query("address") String account_address);

}
