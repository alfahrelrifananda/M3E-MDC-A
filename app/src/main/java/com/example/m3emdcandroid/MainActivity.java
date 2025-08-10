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
import com.example.m3emdcandroid.ui.component.FABMenuActivity;
import com.example.m3emdcandroid.ui.component.FABsActivity;
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
        MaterialCardView demoCard = findViewById(R.id.app_bars_card);
        MaterialCardView bgCard = findViewById(R.id.button_groups_card);
        MaterialCardView cbCard = findViewById(R.id.common_buttons_card);
        MaterialCardView efCard = findViewById(R.id.extended_fab_card);
        MaterialCardView fmCard = findViewById(R.id.fab_menu_card);
        MaterialCardView fCard = findViewById(R.id.fabs_card);

        demoCard.setOnClickListener(v -> {
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
            Intent intent = new Intent(this, CommonButtonActivity.class);
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

    }
}