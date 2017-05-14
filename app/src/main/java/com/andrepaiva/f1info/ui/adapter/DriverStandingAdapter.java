package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.DriverStanding;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class DriverStandingAdapter extends BaseAdapter<DriverStandingAdapter.DsViewHolder, DriverStanding> {

    public DriverStandingAdapter(List<DriverStanding> items) {
        super(items);
    }

    @Override
    public DsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_standings_item, parent, false);

        return new DsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DsViewHolder holder, int position) {
        final DriverStanding driverStanding = items.get(position);
        holder.driverStdName.setText(driverStanding.getDriver().getFamilyName());
        holder.driverStdNPoints.setText(driverStanding.getPoints());
        holder.driverStdPosition.setText(driverStanding.getPosition());
        holder.driverStdConst.setText(driverStanding.getConstructors().get(0).getName());
    }

    static class DsViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout driverStandingsCard;
        private TextView driverStdName;
        private final TextView driverStdPosition;
        private final TextView driverStdNPoints;
        private final TextView driverStdConst;

        DsViewHolder(View itemView) {
            super(itemView);
            driverStandingsCard = (RelativeLayout) itemView.findViewById(R.id.driver_standings_card);
            driverStdName = (TextView) driverStandingsCard.findViewById(R.id.driver_std_name);
            driverStdPosition = (TextView) driverStandingsCard.findViewById(R.id.driver_std_position);
            driverStdNPoints = (TextView) driverStandingsCard.findViewById(R.id.driver_std_points);
            driverStdConst = (TextView) driverStandingsCard.findViewById(R.id.driver_std_const);
        }
    }
}
