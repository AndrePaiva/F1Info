package com.andrepaiva.f1info.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrepaiva.f1info.R;
import com.andrepaiva.f1info.data.model.ApiEntities.QualifyingResult;
import com.andrepaiva.f1info.ui.listeners.OnQualifyingItemClick;

import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public class QualifyingAdapter extends BaseAdapter<QualifyingAdapter.QViewHolder, QualifyingResult> {

    private OnQualifyingItemClick onQualifyingItemClick;

    public QualifyingAdapter(List<QualifyingResult> items, OnQualifyingItemClick onQualifyingItemClick) {
        super(items);
        this.onQualifyingItemClick = onQualifyingItemClick;
    }

    @Override
    public QViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.qualifying_item, parent, false);

        return new QViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QViewHolder holder, int position) {
        final QualifyingResult qualifyingResult = items.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onQualifyingItemClick != null){
                    onQualifyingItemClick.onQualifyingClick(qualifyingResult);
                }
            }
        });
        holder.qDriverName.setText(qualifyingResult.getDriver().getGivenName() + " " + qualifyingResult.getDriver().getFamilyName());
        holder.qDriverPosition.setText(qualifyingResult.getPosition());
        holder.qDriverConst.setText(qualifyingResult.getConstructor().getName());

        String q2 = qualifyingResult.getQ2();
        String q3 = qualifyingResult.getQ3();
        holder.qDriverQ1.setText("Q1: " + qualifyingResult.getQ1());
        if (q2 != null){
            holder.qDriverQ2.setText("Q2: " + q2);
        }
        if (q3 != null){
            holder.qDriverQ3.setText("Q3: " + q3);
        }
    }

    static class QViewHolder extends RecyclerView.ViewHolder {

        private CardView qualifyingCard;
        private TextView qDriverName;
        private final TextView qDriverPosition;
        private final TextView qDriverConst;
        private final TextView qDriverQ1;
        private final TextView qDriverQ2;
        private final TextView qDriverQ3;

        QViewHolder(View itemView) {
            super(itemView);
            qualifyingCard = (CardView) itemView.findViewById(R.id.qualifying_card);
            qDriverName = (TextView) qualifyingCard.findViewById(R.id.q_driver_name);
            qDriverPosition = (TextView) qualifyingCard.findViewById(R.id.q_driver_position);
            qDriverConst = (TextView) qualifyingCard.findViewById(R.id.q_driver_const);
            qDriverQ1 = (TextView) qualifyingCard.findViewById(R.id.q_driver_q1);
            qDriverQ2 = (TextView) qualifyingCard.findViewById(R.id.q_driver_q2);
            qDriverQ3 = (TextView) qualifyingCard.findViewById(R.id.q_driver_q3);
        }
    }
}
