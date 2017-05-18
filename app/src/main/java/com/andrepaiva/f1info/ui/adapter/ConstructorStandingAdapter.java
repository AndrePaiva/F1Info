package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.ConstructorStanding;
import com.andrepaiva.f1info.ui.listeners.OnConstructorStandingItemClick;
import com.andrepaiva.f1info.utils.FlagUtils;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class ConstructorStandingAdapter extends BaseAdapter<ConstructorStandingAdapter.CsViewHolder, ConstructorStanding> {

    private OnConstructorStandingItemClick onConstructorStandingItemClick;

    public ConstructorStandingAdapter(List<ConstructorStanding> items, OnConstructorStandingItemClick onConstructorStandingItemClick) {
        super(items);
        this.onConstructorStandingItemClick = onConstructorStandingItemClick;
    }

    @Override
    public CsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.constructor_standings_item, parent, false);

        return new CsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CsViewHolder holder, int position) {
        final ConstructorStanding constructorStanding = items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConstructorStandingItemClick != null){
                    onConstructorStandingItemClick.onConstructorStandingClick(constructorStanding);
                }
            }
        });
        holder.constructorStdName.setText(constructorStanding.getConstructor().getName());
        holder.constructorStdPoints.setText(constructorStanding.getPoints() + " points");
        holder.constructorStdPosition.setText(constructorStanding.getPosition());
        holder.constructorStdWins.setText("Wins: " + constructorStanding.getWins());
        holder.constructorStdFlag.setImageResource(FlagUtils.getFlagByNationality(constructorStanding.getConstructor().getNationality()));
    }

    static class CsViewHolder extends RecyclerView.ViewHolder {

        private CardView constructorStandingsCard;
        private TextView constructorStdName;
        private final TextView constructorStdPosition;
        private final TextView constructorStdPoints;
        private final TextView constructorStdWins;
        private final ImageView constructorStdFlag;

        CsViewHolder(View itemView) {
            super(itemView);
            constructorStandingsCard = (CardView) itemView.findViewById(R.id.constructor_standings_card);
            constructorStdName = (TextView) constructorStandingsCard.findViewById(R.id.constructor_std_name);
            constructorStdPosition = (TextView) constructorStandingsCard.findViewById(R.id.constructor_std_position);
            constructorStdPoints = (TextView) constructorStandingsCard.findViewById(R.id.constructor_std_points);
            constructorStdWins = (TextView) constructorStandingsCard.findViewById(R.id.constructor_std_wins);
            constructorStdFlag = (ImageView) constructorStandingsCard.findViewById(R.id.constructor_std_flag);
        }
    }
}
