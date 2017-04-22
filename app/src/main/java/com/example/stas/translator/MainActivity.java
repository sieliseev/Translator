package com.example.stas.translator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    HistoryFragment historyFragment;
    TranslatorFragment translatorFragment;
    SettingsFragment settingsFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        historyFragment = new HistoryFragment();
        settingsFragment = new SettingsFragment();

       // if (savedInstanceState == null) {


        translatorFragment = new TranslatorFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, translatorFragment);
        transaction.commit();



//        else {
       //     translatorFragment = (TranslatorFragment) getSupportFragmentManager().findFragmentById(R.id.translatorFragment);
        //    Toast.makeText(this, "Laga", Toast.LENGTH_LONG).show();
      //  }
//
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_translator:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_container, translatorFragment).commit();
                        return true;
                    case R.id.action_history:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_container, historyFragment).commit();
                        return true;
                    case R.id.action_settings:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_container, settingsFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }


}
