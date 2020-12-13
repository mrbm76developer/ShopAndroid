package com.example.login_signup.Engine.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Context context;
    private final int resource;
    private final int size;
    private final RecyclerViewMethod recyclerViewMethod;
    private final LayoutInflater inflater;

    public Adapter(Context context, int resource, int size, RecyclerViewMethod recyclerViewMethod) {
        this.context = context;
        this.resource = resource;
        this.size = size;
        this.recyclerViewMethod = recyclerViewMethod;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(resource, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        recyclerViewMethod.onItem(holder, position, holder.itemView);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
