package com.andrepaiva.f1info.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 27/04/2017.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH>{

    protected List<T> items;

    public BaseAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void appendItems(@NonNull List<T> items) {

        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void setContent(@NonNull List<T> items) {

        this.items.clear();
        this.items = new ArrayList<>(items);
        notifyDataSetChanged();
    }
}
