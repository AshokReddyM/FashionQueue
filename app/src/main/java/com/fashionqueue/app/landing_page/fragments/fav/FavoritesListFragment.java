package com.fashionqueue.app.landing_page.fragments.fav;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;
import com.fashionqueue.app.data.modals.Product;
import com.fashionqueue.app.landing_page.MainActivity;
import com.fashionqueue.app.landing_page.fragments.home.adapter.ProductsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesListFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ProductsAdapter mAdapter;

    ArrayList<Product> productArrayList;


    public FavoritesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_favorites_list, container, false);
        ButterKnife.bind(this, view);

        productArrayList = new ArrayList<>();

        mAdapter = new ProductsAdapter(productArrayList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).toolbar.setTitle("Favorites");
    }
}
