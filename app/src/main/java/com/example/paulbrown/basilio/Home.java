package com.example.paulbrown.basilio;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.paulbrown.basilio.fragments.FragmentAbout;
import com.example.paulbrown.basilio.fragments.FragmentInstruction;
import com.example.paulbrown.basilio.fragments.FragmentSettings;


public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentSettings fsettings;
    private FragmentInstruction finst;
    private FragmentAbout fabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//чот добавилa
        fsettings = new FragmentSettings();
        fabout = new FragmentAbout();
        finst = new FragmentInstruction();
    }

    @Override
    public void onPause(){

        super.onPause();
    }

    @Override
    public void onStop(){

        super.onStop();
    }

    @Override
    public void onStart(){

        super.onStart();
    }

    @Override
    public void onResume(){

        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {

        super.onRestoreInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        //System.runFinalizersOnExit(true);
        this.finish();

        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        FragmentTransaction ftransaction = getFragmentManager().beginTransaction();

        if (id == R.id.nav_settings) {
            ftransaction.replace(R.id.contain, fsettings);
        } else if (id == R.id.nav_about) {
            ftransaction.replace(R.id.contain, fabout);
        } else if (id == R.id.nav_instruction) {
            ftransaction.replace(R.id.contain, finst);
        }

        ftransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


/*
 if (null != getSupportActionBar())
            getSupportActionBar().hide();
*/
