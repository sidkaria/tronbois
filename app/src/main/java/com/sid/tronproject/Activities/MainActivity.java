package com.sid.tronproject.Activities;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sid.tronproject.API.APIEndpoint;
import com.sid.tronproject.API.TransactionsAdapter;
import com.sid.tronproject.R;
import com.sid.tronproject.Responses.TransactionResponse;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

//    private Handler handler;

    public static final String BASE_URL = "https://calhacksproject.herokuapp.com/";
    String account_address = "TE6uKNnQBV12p6sfuGbAjsSLePfx3Z7eBc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIEndpoint api = retrofit.create(APIEndpoint.class);

        Call<String> addressCall = api.getAddress(account_address);
        Call<String> balanceCall = api.getBalance(account_address);
        Call<ArrayList<TransactionResponse>> transactionCall = api.getTransactions(account_address);

//        handler = new Handler();
        final TextView addressTV = findViewById(R.id.address_tv);
        final TextView balanceTV = findViewById(R.id.balance_tv);
        final ListView transactionList = findViewById(R.id.transaction_list);

        addressTV.setText(account_address);

        getData(addressCall, balanceCall, transactionCall, addressTV, balanceTV, transactionList);

//        Button uncompromised = findViewById(R.id.uncompromised_button);
//        Button compromised = findViewById(R.id.compromised_button);
//
//        uncompromised.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendPost(0, 0);
//            }
//        });
//
//        compromised.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendPost(0, 0);
//            }
//        });
    }

    public void getData(Call<String> addressCall, Call<String> balanceCall, Call<ArrayList<TransactionResponse>> transactionCall, final TextView addressTV, final TextView balanceTV, final ListView transactionList) {
//        addressCall.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String address = response.body();
//                addressTV.setText(address);
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                addressTV.setText("Error loading data");
//                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
//            }
//        });

        balanceCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String balance = response.body();
                balanceTV.setText("Your Balance: " + balance + " points");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                addressTV.setText("Error loading data");
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

//        transactionCall.enqueue(new Callback<ArrayList<TransactionResponse>>() {
//            @Override
//            public void onResponse(Call<ArrayList<TransactionResponse>> call, Response<ArrayList<TransactionResponse>> response) {
////                ArrayList<TransactionResponse> transactions = response.body();
////                transactionList.setAdapter(new TransactionsAdapter(MainActivity.this, transactions));
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<TransactionResponse>> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    //    public void sendPost(double lat, double lon) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL("");
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setRequestMethod("POST");
//                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//                    conn.setRequestProperty("Accept","application/json");
//                    conn.setDoOutput(true);
//                    conn.setDoInput(true);
//
//                    JSONObject jsonParam = new JSONObject();
//                    jsonParam.put("timestamp", 1488873360);
//                    jsonParam.put("uname", "");
//                    jsonParam.put("message", "");
//                    jsonParam.put("latitude", 0D);
//                    jsonParam.put("longitude", 0D);
//
//                    Log.i("JSON", jsonParam.toString());
//                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//                    //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
//                    os.writeBytes(jsonParam.toString());
//
//                    os.flush();
//                    os.close();
//
//                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
//                    Log.i("MSG" , conn.getResponseMessage());
//
//                    conn.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        thread.start();
//    }
}
