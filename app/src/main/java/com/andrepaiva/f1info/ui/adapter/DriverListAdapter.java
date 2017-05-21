package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.Driver;
import com.andrepaiva.f1info.ui.listeners.OnDriverListItemClick;
import com.andrepaiva.f1info.utils.DateUtils;
import com.andrepaiva.f1info.utils.ImageUtils;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class DriverListAdapter extends BaseAdapter<DriverListAdapter.DlViewHolder, Driver> {

    private OnDriverListItemClick onDriverListItemClick;

    public DriverListAdapter(List<Driver> items, OnDriverListItemClick onDriverListItemClick) {
        super(items);
        this.onDriverListItemClick = onDriverListItemClick;
    }

    @Override
    public DlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_list_item, parent, false);

        return new DlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DlViewHolder holder, int position) {
        final Driver driver = items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onDriverListItemClick != null){
                    onDriverListItemClick.onDriverListClick(driver);
                }
            }
        });
        holder.driverName.setText(driver.getGivenName() + " " + driver.getFamilyName());
        holder.driverNumber.setText(driver.getPermanentNumber());
        holder.driverBirth.setText(DateUtils.adjustDate(driver.getDateOfBirth()));
        holder.driverFlag.setImageResource(ImageUtils.getFlagByNationality(driver.getNationality()));
    }

    static class DlViewHolder extends RecyclerView.ViewHolder {

        private CardView driverListCard;
        private TextView driverName;
        private final TextView driverNumber;
        private final TextView driverBirth;
        private final ImageView driverFlag;

        DlViewHolder(View itemView) {
            super(itemView);
            driverListCard = (CardView) itemView.findViewById(R.id.driver_list_card);
            driverName = (TextView) driverListCard.findViewById(R.id.driver_list_name);
            driverNumber = (TextView) driverListCard.findViewById(R.id.driver_list_number);
            driverBirth = (TextView) driverListCard.findViewById(R.id.driver_list_birth);
            driverFlag = (ImageView) driverListCard.findViewById(R.id.driver_list_flag);
        }
    }
}
