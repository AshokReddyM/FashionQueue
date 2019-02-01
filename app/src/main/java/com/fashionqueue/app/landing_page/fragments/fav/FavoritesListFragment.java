package com.fashionqueue.app.landing_page.fragments.fav;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashionqueue.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesListFragment extends Fragment {


    public FavoritesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_list, container, false);
    }

}
