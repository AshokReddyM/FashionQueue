package com.fashionqueue.app.landing_page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fashionqueue.app.R;
import com.fashionqueue.app.landing_page.fragments.fav.FavoritesListFragment;
import com.fashionqueue.app.landing_page.fragments.home.fragment.HomeFragment;
import com.fashionqueue.app.landing_page.fragments.offers.OffersFragment;
import com.fashionqueue.app.landing_page.fragments.profile.ProfileFragment;
import com.fashionqueue.app.utils.SharedPrefUtil;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    FrameLayout container;

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle
        );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Renting");


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        int tabId = getIntent().getIntExtra("fragment_id", 0);
        bottomBar.setDefaultTabPosition(tabId);


        int gender = SharedPrefUtil.SharedPrefsUtils.getIntegerPreference(this, "gender_type", -1);

        if (gender == 0) {
            Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.tab_fav:
                        fragmentReplace(new FavoritesListFragment());
                        break;
                    case R.id.tab_offers:
                        fragmentReplace(new OffersFragment());
                        break;
                    case R.id.tab_home:
                        fragmentReplace(new HomeFragment());
                        break;
                    case R.id.tab_profile:
                        fragmentReplace(new ProfileFragment());
                        break;

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void fragmentReplace(Fragment fragment) {
        // Create new fragment and transaction
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_animation, R.anim.exit_animation)
                .replace(R.id.container, fragment)
                .commit();
    }

}
