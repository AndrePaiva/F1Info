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
import com.andrepaiva.f1info.data.model.ApiEntities.Race;
import com.andrepaiva.f1info.data.source.remote.CalendarAsyncTask;
import com.andrepaiva.f1info.ui.adapter.CalendarAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

public class CalendarFragment extends Fragment{
    private static final String TAG = CalendarFragment.class.getSimpleName();
    private SuperRecyclerView superRecyclerView;

    private CalendarAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calendar_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Calendar");

        task = new CalendarAsyncTask(new CalendarAsyncTask.Callback(){

            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(List<Race> races) {
                Log.d(TAG, "On Post Execute Call Succeeded");
                CalendarAdapter calendarAdapter = new CalendarAdapter(races, null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                superRecyclerView = (SuperRecyclerView) getView().findViewById(R.id.calendar_list_view);
                superRecyclerView.setAdapter(calendarAdapter);
                superRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Calendar Call Failed");
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
