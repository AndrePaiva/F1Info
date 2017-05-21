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
import com.andrepaiva.f1info.data.model.ApiEntities.Constructor;
import com.andrepaiva.f1info.data.source.remote.ConstructorListAsyncTask;
import com.andrepaiva.f1info.ui.adapter.ConstructorListAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

public class ConstructorListFragment extends Fragment{
    private static final String TAG = ConstructorListFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private ConstructorListAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.constructor_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Constructors");

        task = new ConstructorListAsyncTask(new ConstructorListAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<Constructor> constructorList) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                ConstructorListAdapter constructorListAdapter = new ConstructorListAdapter(constructorList, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.constructor_list_view);
                superRecyclerView.setAdapter(constructorListAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Constructor List Call Failed");
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
