package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.Constructor;
import com.andrepaiva.f1info.ui.listeners.OnConstructorListItemClick;
import com.andrepaiva.f1info.utils.ImageUtils;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class ConstructorListAdapter extends BaseAdapter<ConstructorListAdapter.ClViewHolder, Constructor> {

    private OnConstructorListItemClick onConstructorListItemClick;

    public ConstructorListAdapter(List<Constructor> items, OnConstructorListItemClick onConstructorListItemClick) {
        super(items);
        this.onConstructorListItemClick = onConstructorListItemClick;
    }

    @Override
    public ClViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.constructor_list_item, parent, false);

        return new ClViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClViewHolder holder, int position) {
        final Constructor constructor = items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConstructorListItemClick != null){
                    onConstructorListItemClick.onConstructorListClick(constructor);
                }
            }
        });
        holder.constructorName.setText(constructor.getName());
        holder.constructorLogo.setImageResource(ImageUtils.getLogoByConstrutorId(constructor.getConstructorId()));
        holder.constructorFlag.setImageResource(ImageUtils.getFlagByNationality(constructor.getNationality()));
    }

    static class ClViewHolder extends RecyclerView.ViewHolder {

        private CardView constructorListCard;
        private TextView constructorName;
        private final ImageView constructorLogo;
        private final ImageView constructorFlag;

        ClViewHolder(View itemView) {
            super(itemView);
            constructorListCard = (CardView) itemView.findViewById(R.id.constructor_list_card);
            constructorName = (TextView) constructorListCard.findViewById(R.id.constructor_list_name);
            constructorLogo = (ImageView) constructorListCard.findViewById(R.id.constructor_list_logo);
            constructorFlag = (ImageView) constructorListCard.findViewById(R.id.constructor_list_flag);
        }
    }
}
