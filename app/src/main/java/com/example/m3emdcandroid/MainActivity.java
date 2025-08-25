package com.example.m3emdcandroid;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView toolbarTitle;
    private CollapsingToolbarLayout collapsingToolbar;
    private String currentTitle = "M3 EMD Components";

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
        }
    }

    private void enableEdgeToEdge() {
        EdgeToEdge.enable(this);
        getWindow().setNavigationBarColor(android.graphics.Color.TRANSPARENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            getWindow().setNavigationBarContrastEnforced(false);
        }

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }

    private void setupWindowInsets() {
        View rootView = findViewById(R.id.container);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, windowInsets) -> {
                androidx.core.graphics.Insets navigationBar = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());
                return WindowInsetsCompat.CONSUMED;
            });
        }
    }

    private void setupToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title_main);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);

        if (toolbar != null && toolbarTitle != null && collapsingToolbar != null && appBarLayout != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }

            collapsingToolbar.setTitle(currentTitle);
            setupCollapsingToolbarTitleAnimation(appBarLayout);
        }
    }

    private void setupCollapsingToolbarTitleAnimation(AppBarLayout appBarLayout) {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (toolbarTitle == null || collapsingToolbar == null) {
                    return;
                }

                int totalScrollRange = appBarLayout.getTotalScrollRange();
                float percentage = Math.abs(verticalOffset) / (float) totalScrollRange;

                if (percentage > 0.7f) {
                    toolbarTitle.setVisibility(View.VISIBLE);
                    float alpha = (percentage - 0.7f) / 0.3f;
                    toolbarTitle.setAlpha(alpha);
                    collapsingToolbar.setTitle("");
                } else {
                    toolbarTitle.setVisibility(View.INVISIBLE);
                    toolbarTitle.setAlpha(0f);
                    collapsingToolbar.setTitle(currentTitle);
                }
            }
        });
    }

    private void setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.nav_view);
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
        if (toolbarTitle != null) {
            toolbarTitle.setText(currentTitle);
        }
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