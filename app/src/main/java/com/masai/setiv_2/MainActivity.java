package com.masai.setiv_2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextView mTvHospitalizedCurrently;
    private TextView mTvOnVentilatorCurrently;
    private TextView mTvPositive;

    private RecyclerView mRecyclerView;
    private List<ResponseModel> postModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        initViews();
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String vaccine = mTvHospitalizedCurrently.getText().toString();
        apiService.getPosts(vaccine).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if (response.body() != null) {
                    postModelList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        PostAdapter postAdapter = new PostAdapter(postModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(postAdapter);
    }

    private void initViews() {
        mTvHospitalizedCurrently = findViewById(R.id.tvHospitalizedCurrently);
        mTvOnVentilatorCurrently = findViewById(R.id.tvOnVentilatorCurrently);
        mTvPositive = findViewById(R.id.tvPositive);
        mRecyclerView = findViewById(R.id.recyclerView);
    }
}