package com.andrepaiva.f1info.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.DashboardResponse;
import com.andrepaiva.f1info.data.source.remote.DashboardAsyncTask;
import com.andrepaiva.f1info.utils.DateUtils;
import com.andrepaiva.f1info.utils.ImageUtils;
import com.google.gson.Gson;

public class DashboardFragment extends Fragment {

    private static final String TAG = DashboardFragment.class.getSimpleName();

    private DashboardAsyncTask task;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dashboard, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("F1 Info");

        task = new DashboardAsyncTask(new DashboardAsyncTask.Callback() {

            @Override
            public void onPreExecute() {
                Log.d(TAG, "On Pre Execute Call Succeeded");
            }

            @Override
            public void onPostExecute(DashboardResponse model) {
                Log.d(TAG, "On Post Execute Call Succeeded");

                Gson gson = new Gson();
                Log.d(TAG, "Teste 1: " + (gson.toJson(model.getLastResults())));
                TextView p1Name = (TextView)getView().findViewById(R.id.P1_name);
                p1Name.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(0).getDriver().getFamilyName());

                TextView p1Time = (TextView)getView().findViewById(R.id.P1_time);
                p1Time.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(0).getTime().getTime());

                /*P2*/
                TextView p2Name = (TextView) getView().findViewById(R.id.P2_name);
                p2Name.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(1).getDriver().getFamilyName());

                TextView p2Time = (TextView)getView().findViewById(R.id.P2_time);
                p2Time.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(1).getTime().getTime());

                /*P3*/
                TextView p3Name = (TextView) getView().findViewById(R.id.P3_name);
                p3Name.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(2).getDriver().getFamilyName());

                TextView p3Time = (TextView)getView().findViewById(R.id.P3_time);
                p3Time.setText(model.getLastResults().getMRData().getRaceTable()
                        .getRaces().get(0).getResults().get(2).getTime().getTime());

                /*NEXT GP*/
                Log.d(TAG, "Teste 2: " + (gson.toJson(model.getNextRace())));
                TextView nextPlace = (TextView) getView().findViewById(R.id.next_place);
                nextPlace.setText(model.getNextRace().getMRData().getRaceTable().getRaces().get(0).getRaceName());

                TextView nextCountry = (TextView) getView().findViewById(R.id.next_country);
                nextCountry.setText(model.getNextRace().getMRData().getRaceTable().getRaces()
                        .get(0).getCircuit().getLocation().getCountry());

                ImageView countryFlag = (ImageView) getView().findViewById(R.id.next_country_flag);
                String country = model.getNextRace().getMRData().getRaceTable().getRaces()
                        .get(0).getCircuit().getLocation().getCountry();
                countryFlag.setImageResource(ImageUtils.getFlagResource(country));

                TextView nextCircuit = (TextView) getView().findViewById(R.id.next_circuit);
                nextCircuit.setText(model.getNextRace().getMRData().getRaceTable().getRaces()
                        .get(0).getCircuit().getCircuitName());

                TextView nextSchedule = (TextView) getView().findViewById(R.id.next_schedule);
                String raceDate = model.getNextRace().getMRData().getRaceTable().getRaces().get(0).getDate();
                nextSchedule.setText(DateUtils.adjustDate(raceDate));

                TextView nextTime = (TextView) getView().findViewById(R.id.next_time);
                String raceDTime = model.getNextRace().getMRData().getRaceTable().getRaces().get(0).getTime();
                nextTime.setText(DateUtils.adjustTimeZone(raceDTime));

                /*DASHBOARD DRIVER STANDINGS*/
                Log.d(TAG, "Teste 3: " + (gson.toJson(model.getDriverStandings())));
                /*P1*/
                TextView p1StandingName = (TextView) getView().findViewById(R.id.dashb_std_p1_name);
                p1StandingName.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(0).getDriver().getFamilyName());

                TextView p1StandingPoints = (TextView) getView().findViewById(R.id.dashb_std_p1_points);
                p1StandingPoints.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(0).getPoints());

                TextView p1StandingWins = (TextView) getView().findViewById(R.id.dashb_std_p1_wins);
                p1StandingWins.setText("Wins: " + model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(0).getWins());

                /*P2*/
                TextView p2StandingName = (TextView) getView().findViewById(R.id.dashb_std_p2_name);
                p2StandingName.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(1).getDriver().getFamilyName());

                TextView p2StandingPoints = (TextView) getView().findViewById(R.id.dashb_std_p2_points);
                p2StandingPoints.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(1).getPoints());

                TextView p2StandingWins = (TextView) getView().findViewById(R.id.dashb_std_p2_wins);
                p2StandingWins.setText("Wins: " + model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(1).getWins());

                /*P3*/
                TextView p3StandingName = (TextView) getView().findViewById(R.id.dashb_std_p3_name);
                p3StandingName.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(2).getDriver().getFamilyName());

                TextView p3StandingPoints = (TextView) getView().findViewById(R.id.dashb_std_p3_points);
                p3StandingPoints.setText(model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(2).getPoints());

                TextView p3StandingWins = (TextView) getView().findViewById(R.id.dashb_std_p3_wins);
                p3StandingWins.setText("Wins: " + model.getDriverStandings().getMRData().getStandingsTable()
                        .getStandingsLists().get(0).getDriverStandings().get(2).getWins());

            }

            @Override
            public void onError(Throwable throwable) {
                Log.e(TAG, "Dashboard Call Failed");
            }
        });
        task.execute();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (task != null && task.getStatus() != AsyncTask.Status.FINISHED) {
            task.cancel(true);
        }
    }
}