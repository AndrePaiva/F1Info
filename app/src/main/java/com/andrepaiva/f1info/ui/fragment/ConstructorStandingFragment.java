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
import com.andrepaiva.f1info.data.model.ApiEntities.ConstructorStanding;
import com.andrepaiva.f1info.data.source.remote.ConstructorStandingAsyncTask;
import com.andrepaiva.f1info.ui.adapter.ConstructorStandingAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

public class ConstructorStandingFragment extends Fragment{

    private static final String TAG = ConstructorStandingFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private ConstructorStandingAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.constructor_standings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Constructor Standing");

        task = new ConstructorStandingAsyncTask(new ConstructorStandingAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<ConstructorStanding> constructorStandings) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                ConstructorStandingAdapter constructorStandingAdapter = new ConstructorStandingAdapter(constructorStandings, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.constructor_standings_view);
                superRecyclerView.setAdapter(constructorStandingAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Driver Standings Call Failed");
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
