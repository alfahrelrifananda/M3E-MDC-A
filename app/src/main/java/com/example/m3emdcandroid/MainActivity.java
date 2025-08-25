package com.example.m3emdcandroid;

import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.m3emdcandroid.ui.HomeFragment;
import com.example.m3emdcandroid.ui.SettingsFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private CollapsingToolbarLayout collapsingToolbar;
    private String currentTitle = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableEdgeToEdge();
        setContentView(R.layout.activity_main);

        setupWindowInsets();
        setupToolbar();
        setupBottomNavigation();

        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }

    private void enableEdgeToEdge() {
        EdgeToEdge.enable(this);
        getWindow().setNavigationBarColor(android.graphics.Color.TRANSPARENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            getWindow().setNavigationBarContrastEnforced(false);
        }

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
    }

    private void setupWindowInsets() {
        View rootView = findViewById(R.id.container);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, windowInsets) -> {
                androidx.core.graphics.Insets systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                androidx.core.graphics.Insets navigationBar = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());

                BottomNavigationView bottomNav = findViewById(R.id.nav_view);
                if (bottomNav != null) {
                    bottomNav.setPadding(0, 0, 0, navigationBar.bottom);
                }

                return windowInsets;
            });
        }
    }

    private void setupToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        collapsingToolbar = findViewById(R.id.collapsingtoolbarlayout);
        AppBarLayout appBarLayout = findViewById(R.id.appbarlayout);

        if (toolbar != null && collapsingToolbar != null && appBarLayout != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }

            collapsingToolbar.setTitle(currentTitle);
        }
    }

    private void setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.nav_view);
        if (bottomNavigationView == null) {
            return;
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            String newTitle = currentTitle;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                selectedFragment = new HomeFragment();
                newTitle = "Home";
            } else if (itemId == R.id.nav_settings) {
                selectedFragment = new SettingsFragment();
                newTitle = "Settings";
            }

            if (selectedFragment != null) {
                updateTitle(newTitle);
                replaceFragment(selectedFragment);
                return true;
            }
            return false;
        });
    }

    private void updateTitle(String title) {
        currentTitle = title;
        if (collapsingToolbar != null) {
            collapsingToolbar.setTitle(currentTitle);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}