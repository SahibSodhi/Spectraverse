package com.spectraverse.spectraverse.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spectraverse.spectraverse.R;
import com.spectraverse.spectraverse.fragments.AboutUsFragment;
import com.spectraverse.spectraverse.fragments.BlogFragment;
import com.spectraverse.spectraverse.fragments.HomeFragment;
import com.spectraverse.spectraverse.fragments.LearningFragment;
import com.spectraverse.spectraverse.fragments.VideosFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private TextView websiteLink;
    private ActionBarDrawerToggle toggle;
    private long backPressedTime;
    private Toast backToast;

    Intent intent = new Intent(Intent.ACTION_VIEW);
    private View navHeader;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);


        toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();*/
            replaceFragment(new HomeFragment(), null, true);
            navigationView.setCheckedItem(R.id.nav_home);
        }

        websiteLink = navHeader.findViewById(R.id.websiteLink);
        websiteLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("https://www.spectraverse.in/"));
                startActivity(intent);
            }

        });

        backPressedTime=0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();*/
                replaceFragment(new HomeFragment(), null, true);
                break;
            case R.id.nav_blog:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlogFragment()).commit();*/
                replaceFragment(new BlogFragment(), null, true);
                break;
            case R.id.nav_about_us:
               /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUsFragment()).commit();*/
                replaceFragment(new AboutUsFragment(), null, true);
                break;
            case R.id.nav_instagram:
                intent.setData(Uri.parse("https://www.instagram.com/spectraverse/"));
                startActivity(intent);
                break;
            case R.id.nav_facebook:
                intent.setData(Uri.parse("https://www.facebook.com/spectraverse/"));
                startActivity(intent);
                break;
            case R.id.nav_twitter:
                intent.setData(Uri.parse("https://twitter.com/Spectraverse1"));
                startActivity(intent);
                break;
            case R.id.nav_linkedin:
                intent.setData(Uri.parse("https://www.linkedin.com/company/spectraverse1/"));
                startActivity(intent);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            return;
        }

        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() == 1) {
            exitApplication();
            return;
        }
        super.onBackPressed();
    }

    public void exitApplication() {

        long delayTimeForExitToast = 2000;
        if (backPressedTime + delayTimeForExitToast > System.currentTimeMillis()) {
            backToast.cancel();
            finish();
        } else {
            backToast = Toast.makeText(getBaseContext(), getString(R.string.press_back_msg), Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    Fragment getCurrentFragment()
    {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        return currentFragment;
    }

    public void replaceFragment(Fragment newFragment, Bundle bundle, boolean isAddToBackStack) {

        String tag = newFragment.getClass().getSimpleName();
        if (bundle != null) {
            newFragment.setArguments(bundle);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (getCurrentFragment() != null) {
            ft.hide(getCurrentFragment());
        }
        ft.add(R.id.fragment_container, newFragment, tag);
        newFragment.setRetainInstance(true);
        if (isAddToBackStack) {
            ft.addToBackStack(tag);
        }
        try {
            ft.commitAllowingStateLoss();
        } catch (Exception ex) {
            ex.printStackTrace();
//            ft.commitAllowingStateLoss();
        }
    }

}
