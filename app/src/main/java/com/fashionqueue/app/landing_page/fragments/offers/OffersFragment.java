package com.fashionqueue.app.landing_page.fragments.offers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;
import com.fashionqueue.app.data.modals.Product;
import com.fashionqueue.app.landing_page.MainActivity;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private OffersAdapter mAdapter;

    ArrayList<Product> productArrayList;


    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_offers, container, false);
        ButterKnife.bind(this, view);

        productArrayList = new ArrayList<>();

        mAdapter = new OffersAdapter(productArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) Objects.requireNonNull(getActivity())).toolbar.setTitle("Offers");
    }

}
