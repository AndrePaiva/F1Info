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
import com.andrepaiva.f1info.data.model.ApiEntities.QualifyingResult;
import com.andrepaiva.f1info.data.source.remote.QualifyingAsyncTask;
import com.andrepaiva.f1info.ui.adapter.QualifyingAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

public class QualifyingFragment extends Fragment{

    private static final String TAG = QualifyingFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private QualifyingAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.qualifying, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Qualifying");

        task = new QualifyingAsyncTask(new QualifyingAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<QualifyingResult> qualifyingResults) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                QualifyingAdapter qualifyingAdapter = new QualifyingAdapter(qualifyingResults, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.qualifying_view);
                superRecyclerView.setAdapter(qualifyingAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Qualifying Call Failed");
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
