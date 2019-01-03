package com.spectraverse.spectraverse.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
    Intent intent = new Intent(Intent.ACTION_VIEW);
    private View navHeader;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
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


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            /*case R.id.nav_learning:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LearningFragment()).commit();
                break;
            case R.id.nav_videos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VideosFragment()).commit();
                break;*/

            case R.id.nav_blog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlogFragment()).commit();
                break;
            case R.id.nav_about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUsFragment()).commit();
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
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
