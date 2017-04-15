package com.andrepaiva.f1info.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.ApiResponse;
import com.andrepaiva.f1info.data.model.ApiEntities.MRData;
import com.andrepaiva.f1info.data.source.remote.APIHelper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class DashboardFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);

        Call<ApiResponse> lastResultsCall = APIHelper.f1ApiClient.getLastResults();
        lastResultsCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                if(response.body() == null) {
                    try {
                        response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getActivity(), "No Results!", Toast.LENGTH_SHORT).show();
                } else {
                    ApiResponse lasResultsResponse = response.body();
                    Log.d(TAG, "Last Results Call Succeeded");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(TAG,"Last Results Call Failed");
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("F1 Info");
    }
}
