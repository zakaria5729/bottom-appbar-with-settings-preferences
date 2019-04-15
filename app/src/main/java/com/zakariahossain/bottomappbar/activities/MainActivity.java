package com.zakariahossain.bottomappbar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.zakariahossain.bottomappbar.fragments.BottomNavigationDrawerFragment;
import com.zakariahossain.bottomappbar.fragments.DefaultFragment;
import com.zakariahossain.bottomappbar.R;
import com.zakariahossain.bottomappbar.interfaces.OnMyInterface;
import com.zakariahossain.bottomappbar.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity implements OnMyInterface {

    private BottomAppBar bottomAppBar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        setSupportActionBar(bottomAppBar);

        if (savedInstanceState == null) {
            replaceFragment(new DefaultFragment());
        }

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "fab", Toast.LENGTH_SHORT).show();
                 Snackbar.make(coordinatorLayout, "fdfdffddfdfdfdfdfdfdfdfdfdfdfd", Snackbar.LENGTH_SHORT).setAction("Click", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BottomNavigationDrawerFragment().show(getSupportFragmentManager(), null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                replaceFragment(new DefaultFragment());
                Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.close:
                Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                replaceFragment(new SettingsFragment());
                break;
        }

        return true;
    }

    @Override
    public void onMyFragment(Fragment fragment) {
        replaceFragment(fragment);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
