package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.Race;
import com.andrepaiva.f1info.ui.listeners.OnCalendarItemClick;
import com.andrepaiva.f1info.utils.DateUtils;
import com.andrepaiva.f1info.utils.ImageUtils;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class CalendarAdapter extends BaseAdapter<CalendarAdapter.RlViewHolder, Race> {

    private OnCalendarItemClick onCalendarItemClick;

    public CalendarAdapter(List<Race> items, OnCalendarItemClick onCalendarItemClick) {
        super(items);
        this.onCalendarItemClick = onCalendarItemClick;
    }

    @Override
    public RlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_list_item, parent, false);

        return new RlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RlViewHolder holder, int position) {
        final Race race = items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCalendarItemClick != null){
                    onCalendarItemClick.onCalendarClick(race);
                }
            }
        });
        holder.raceName.setText(race.getRaceName());
        holder.raceCircuit.setText(race.getCircuit().getCircuitName());
        holder.raceCity.setText(race.getCircuit().getLocation().getLocality());
        holder.raceDate.setText(DateUtils.adjustDate(race.getDate()));
        holder.raceCountry.setImageResource(ImageUtils.getFlagResource(race.getCircuit().getLocation().getCountry()));
    }

    static class RlViewHolder extends RecyclerView.ViewHolder {

        private CardView calendarCard;
        private TextView raceName;
        private final TextView raceCircuit;
        private final TextView raceCity;
        private final TextView raceDate;
        private final ImageView raceCountry;

        RlViewHolder(View itemView) {
            super(itemView);
            calendarCard = (CardView) itemView.findViewById(R.id.calendar_list_card);
            raceName = (TextView) calendarCard.findViewById(R.id.calendar_gp);
            raceCircuit = (TextView) calendarCard.findViewById(R.id.calendar_race_circuit);
            raceCity = (TextView) calendarCard.findViewById(R.id.calendar_race_city);
            raceDate = (TextView) calendarCard.findViewById(R.id.calendar_race_date);
            raceCountry = (ImageView) calendarCard.findViewById(R.id.calendar_race_flag);
        }
    }
}
