package com.example.login_signup.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_signup.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Context context;
    private final int resource;
    private final ArrayList<Product> productList;

    public Adapter(Context context, int resource, ArrayList<Product> productList) {
        this.context = context;
        this.resource = resource;
        this.productList = productList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(resource, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Product product = productList.get(position);
        viewHolder.FillItem(product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgLayoutRecyclerView;
        private final TextView txtProductsListItemRecyclerView;
        private final ViewGroup rootGroup;

        public ViewHolder(View itemView) {
            super(itemView);
            imgLayoutRecyclerView = itemView.findViewById(R.id.imgLayoutRecyclerView);
            txtProductsListItemRecyclerView = itemView.findViewById(R.id.txtProductsListItemRecyclerView);
            rootGroup = itemView.findViewById(R.id.rootGroup);
        }

        public void FillItem(Product product) {
            imgLayoutRecyclerView.setImageResource(product.getImageId());
            txtProductsListItemRecyclerView.setText(product.getProductName());
        }
    }
}
