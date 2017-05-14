package com.andrepaiva.f1info.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.DriverStanding;
import com.andrepaiva.f1info.data.source.remote.DriverStandingAsyncTask;
import com.andrepaiva.f1info.ui.adapter.DriverStandingAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class DriverStandingFragment extends Fragment{

    private static final String TAG = DriverStandingFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private DriverStandingAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.driver_standings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Driver Standing");

        task = new DriverStandingAsyncTask(new DriverStandingAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<DriverStanding> driverStandings) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                DriverStandingAdapter driverStandingAdapter = new DriverStandingAdapter(driverStandings, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.driver_standings_view);
                superRecyclerView.setAdapter(driverStandingAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Driver Standings Call Failed");
            }
        });
        task.execute();
    }
}
