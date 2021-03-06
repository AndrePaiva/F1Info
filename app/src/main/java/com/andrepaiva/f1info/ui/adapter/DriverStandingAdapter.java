package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.DriverStanding;
import com.andrepaiva.f1info.ui.listeners.OnDriverStandingItemClick;
import com.andrepaiva.f1info.utils.ImageUtils;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class DriverStandingAdapter extends BaseAdapter<DriverStandingAdapter.DsViewHolder, DriverStanding> {

    private OnDriverStandingItemClick onDriverStandingItemClick;

    public DriverStandingAdapter(List<DriverStanding> items, OnDriverStandingItemClick onDriverStandingItemClick) {
        super(items);
        this.onDriverStandingItemClick = onDriverStandingItemClick;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onDriverStandingItemClick != null){
                    onDriverStandingItemClick.onDriverStandingClick(driverStanding);
                }
            }
        });
        holder.driverStdName.setText(driverStanding.getDriver().getFamilyName());
        holder.driverStdNPoints.setText(driverStanding.getPoints() + " points");
        holder.driverStdPosition.setText(driverStanding.getPosition());
        holder.driverStdConst.setText(driverStanding.getConstructors().get(0).getName());
        holder.driverStdFlag.setImageResource(ImageUtils.getFlagByNationality(driverStanding.getDriver().getNationality()));
    }

    static class DsViewHolder extends RecyclerView.ViewHolder {

        private CardView driverStandingsCard;
        private TextView driverStdName;
        private final TextView driverStdPosition;
        private final TextView driverStdNPoints;
        private final TextView driverStdConst;
        private final ImageView driverStdFlag;

        DsViewHolder(View itemView) {
            super(itemView);
            driverStandingsCard = (CardView) itemView.findViewById(R.id.driver_standings_card);
            driverStdName = (TextView) driverStandingsCard.findViewById(R.id.driver_std_name);
            driverStdPosition = (TextView) driverStandingsCard.findViewById(R.id.driver_std_position);
            driverStdNPoints = (TextView) driverStandingsCard.findViewById(R.id.driver_std_points);
            driverStdConst = (TextView) driverStandingsCard.findViewById(R.id.driver_std_const);
            driverStdFlag = (ImageView) driverStandingsCard.findViewById(R.id.driver_std_flag);
        }
    }
}
