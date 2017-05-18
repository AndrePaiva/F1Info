package com.andrepaiva.f1info.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.Driver;
import com.andrepaiva.f1info.data.source.remote.DriverListAsyncTask;
import com.andrepaiva.f1info.ui.adapter.DriverListAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

public class DriverListFragment extends Fragment{
    private static final String TAG = DriverListFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private DriverListAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.driver_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Drivers");

        task = new DriverListAsyncTask(new DriverListAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<Driver> driverList) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                DriverListAdapter driverListAdapter = new DriverListAdapter(driverList, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.driver_list_view);
                superRecyclerView.setAdapter(driverListAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Driver List Call Failed");
            }
        });
        task.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (task != null && task.getStatus() != AsyncTask.Status.FINISHED) {
            task.cancel(true);
        }
    }
}
