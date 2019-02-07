package com.fashionqueue.app.landing_page.fragments.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsAdapterVH> {

    private ArrayList<Product> productsList;
    private Context context;

    public ProductsAdapter(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_single_item, parent, false);
        return new ProductsAdapterVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapterVH productsAdapterVH, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ProductsAdapterVH extends RecyclerView.ViewHolder {
        public ProductsAdapterVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
