package com.example.m3emdcandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import com.example.m3emdcandroid.ui.component.AppBarActivity;
import com.example.m3emdcandroid.ui.component.ButtonGroupsActivity;
import com.example.m3emdcandroid.ui.component.CommonButtonActivity;
import com.example.m3emdcandroid.ui.component.ExtendedFABActivity;
import com.example.m3emdcandroid.ui.component.FABMenuActivity;
import com.example.m3emdcandroid.ui.component.FABsActivity;
import com.example.m3emdcandroid.ui.component.IconButtonActivity;
import com.example.m3emdcandroid.ui.component.LoadingIndicatorActivity;
import com.example.m3emdcandroid.ui.component.NavigationBarActivity;
import com.example.m3emdcandroid.ui.component.NavigationRailActivity;
import com.example.m3emdcandroid.ui.component.ProgressIndicatorsActivity;
import com.example.m3emdcandroid.ui.component.SlidersActivity;
import com.example.m3emdcandroid.ui.component.SplitButtonActivity;
import com.example.m3emdcandroid.ui.component.ToolbarsActivity;
import com.google.android.material.card.MaterialCardView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        setContentView(R.layout.activity_main);
        setupClickedCard();
    }

    private void setupClickedCard() {
        MaterialCardView abCard = findViewById(R.id.app_bars_card);
        MaterialCardView bgCard = findViewById(R.id.button_groups_card);
        MaterialCardView cbCard = findViewById(R.id.common_buttons_card);
        MaterialCardView efCard = findViewById(R.id.extended_fab_card);
        MaterialCardView fmCard = findViewById(R.id.fab_menu_card);
        MaterialCardView fCard = findViewById(R.id.fabs_card);
        MaterialCardView ibCard = findViewById(R.id.icon_buttons_card);
        MaterialCardView liCard = findViewById(R.id.loading_indicator_card);
        MaterialCardView nbCard = findViewById(R.id.navigation_bar_card);
        MaterialCardView nrCard = findViewById(R.id.navigation_rail_card);
        MaterialCardView piCard = findViewById(R.id.progress_indicators_card);
        MaterialCardView sCard = findViewById(R.id.sliders_card);
        MaterialCardView sbCard = findViewById(R.id.split_button_card);
        MaterialCardView tCard = findViewById(R.id.toolbar_card);



        abCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, AppBarActivity.class);
            startActivity(intent);
        });

        bgCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, ButtonGroupsActivity.class);
            startActivity(intent);
        });

        cbCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, CommonButtonActivity.class);
            startActivity(intent);
        });

        efCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, ExtendedFABActivity.class);
            startActivity(intent);
        });
        fmCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, FABMenuActivity.class);
            startActivity(intent);
        });
        fCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, FABsActivity.class);
            startActivity(intent);
        });

        ibCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, IconButtonActivity.class);
            startActivity(intent);
        });

        liCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoadingIndicatorActivity.class);
            startActivity(intent);
        });
        nbCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, NavigationBarActivity.class);
            startActivity(intent);
        });

        nrCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, NavigationRailActivity.class);
            startActivity(intent);
        });

        piCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgressIndicatorsActivity.class);
            startActivity(intent);
        });

        sCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, SlidersActivity.class);
            startActivity(intent);
        });

        sbCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, SplitButtonActivity.class);
            startActivity(intent);
        });

        tCard.setOnClickListener(v -> {
            Intent intent = new Intent(this, ToolbarsActivity.class);
            startActivity(intent);
        });

    }
}