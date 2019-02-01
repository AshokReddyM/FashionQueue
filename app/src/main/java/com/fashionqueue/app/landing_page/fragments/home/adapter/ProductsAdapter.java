package com.fashionqueue.app.landing_page.fragments.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsAdapterVH> {
    @NonNull
    @Override
    public ProductsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapterVH productsAdapterVH, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductsAdapterVH extends RecyclerView.ViewHolder {
        public ProductsAdapterVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
