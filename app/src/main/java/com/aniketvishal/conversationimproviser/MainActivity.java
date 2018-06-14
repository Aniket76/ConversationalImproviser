package com.aniketvishal.conversationimproviser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aniketvishal.conversationimproviser.Database.DatabaseHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mToolbar;
    private DatabaseHelper mDatabaseHelper;
    SharedPreferences prefs = null;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RateUs.app_launched(this);

        mDatabaseHelper = new DatabaseHelper(this);

        mToolbar = (Toolbar)findViewById(R.id.main_mainpage_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Spoken English Improviser");

        MainFragment fragment = new MainFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_activity_layout,fragment,"MainFragment");
        transaction.commit();


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.main_side_nav);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        try {
            int versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            SharedPreferences prefs = getSharedPreferences("lastUpdate", MODE_PRIVATE);;
            if (prefs.getInt("lastUpdate", 0) != versionCode) {
                try {

                    mDatabaseHelper.getReadableDatabase();
                    if (copyDatabase(this)){
                        Toast.makeText(this,"Words are Added",Toast.LENGTH_LONG).show();
                        prefs.edit().putBoolean("firstrun", false).commit();
                    }else {
                        Toast.makeText(this,"Copy Failed",Toast.LENGTH_LONG).show();
                        return;
                    }
                    // Commiting in the preferences, that the update was successful.
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("lastUpdate", versionCode);
                    editor.commit();
                } catch(Throwable t) {
                    // update failed, or cancelled
                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


//        prefs = getSharedPreferences("dbCheck", MODE_PRIVATE);
//
//        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
//        if (prefs.getBoolean("firstrun", true)){
//
//            mDatabaseHelper.getReadableDatabase();
//            if (copyDatabase(this)){
//                Toast.makeText(this,"Words are Added",Toast.LENGTH_LONG).show();
//                prefs.edit().putBoolean("firstrun", false).commit();
//            }else {
//                Toast.makeText(this,"Copy Failed",Toast.LENGTH_LONG).show();
//                return;
//            }
//
//        }

    }

    private boolean copyDatabase(Context context){
        try{

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outputFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outputFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff))>0){
                outputStream.write(buff,0 , length);
            }
            outputStream.flush();
            outputStream.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


//    void runUpdatesIfNecessary() {
//        try {
//            int versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
//            SharedPreferences prefs = getSharedPreferences("lastUpdate", MODE_PRIVATE);;
//            if (prefs.getInt("lastUpdate", 0) != versionCode) {
//                try {
//
//                    // Commiting in the preferences, that the update was successful.
//                    SharedPreferences.Editor editor = prefs.edit();
//                    editor.putInt("lastUpdate", versionCode);
//                    editor.commit();
//                } catch(Throwable t) {
//                    // update failed, or cancelled
//                }
//            }
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        switch (id){

            case R.id.main_menu_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.aniketvishal.conversationimproviser";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Spoken English Improviser: with Audio");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.side_nav_btn1:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.aniketvishal.conversationimproviser";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Spoken English Improviser: with Audio");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.side_nav_btn2:
                this.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("https://play.google.com/store/apps/details?id=com.aniketvishal.conversationimproviser")));
                break;

            case R.id.side_nav_btn3:
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "contact@aniketvishal.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Spoken English Improviser: with Audio - Feedback");
                startActivity(intent);
                break;

            case R.id.otherapp1:
                this.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("https://play.google.com/store/apps/details?id=com.aniketvishal.commonindianwords")));
                break;
        }

        return false;
    }



}
