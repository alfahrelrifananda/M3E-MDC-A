package com.example.m3emdcandroid.ui.component;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.m3emdcandroid.R;
import com.example.m3emdcandroid.ui.component.webview.WebViewBottomSheetFragment;
import com.google.android.material.appbar.MaterialToolbar;

public class SlidersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        setContentView(R.layout.activity_sliders);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        Button documentationButton = findViewById(R.id.documentation_button);
        documentationButton.setOnClickListener(v -> {
            WebViewBottomSheetFragment bottomSheet = WebViewBottomSheetFragment.newInstance(
                   "https://github.com/material-components/material-components-android/blob/master/docs/components/Slider.md"
            );
            bottomSheet.show(getSupportFragmentManager(), "WebViewBottomSheet");
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}