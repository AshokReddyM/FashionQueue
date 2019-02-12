package com.fashionqueue.app.orders.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;
import com.fashionqueue.app.data.modals.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersCustomAdapter extends RecyclerView.Adapter<OrdersCustomAdapter.OrdersListItemViewHolder> {
    private Context context;
    private List<Order> orders;

    public OrdersCustomAdapter(Context context, ArrayList<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @Override
    public OrdersListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrdersListItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(OrdersListItemViewHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return orders.size();
    }


    public class OrdersListItemViewHolder extends RecyclerView.ViewHolder {


        public OrdersListItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}