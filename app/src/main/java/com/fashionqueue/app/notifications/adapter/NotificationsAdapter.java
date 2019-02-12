package com.fashionqueue.app.notifications.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;
import com.fashionqueue.app.data.modals.Notifications;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ProductsAdapterVH> {

    private ArrayList<Notifications> notifications;
    private Context context;

    public NotificationsAdapter(ArrayList<Notifications> notifications) {
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public ProductsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_single_item, parent, false);
        return new ProductsAdapterVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapterVH vh, int i) {

    }

    @Override
    public int getItemCount() {
        return notifications.size();


    }

    public class ProductsAdapterVH extends RecyclerView.ViewHolder {
        public ProductsAdapterVH(@NonNull View itemView) {
            super(itemView);
        }
    }


}
