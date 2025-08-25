package com.example.m3emdcandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.m3emdcandroid.R;
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

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setupClickedCard(view);

        return view;
    }

    private void setupClickedCard(View view) {
        MaterialCardView abCard = view.findViewById(R.id.app_bars_card);
        MaterialCardView bgCard = view.findViewById(R.id.button_groups_card);
        MaterialCardView cbCard = view.findViewById(R.id.common_buttons_card);
        MaterialCardView efCard = view.findViewById(R.id.extended_fab_card);
        MaterialCardView fmCard = view.findViewById(R.id.fab_menu_card);
        MaterialCardView fCard = view.findViewById(R.id.fabs_card);
        MaterialCardView ibCard = view.findViewById(R.id.icon_buttons_card);
        MaterialCardView liCard = view.findViewById(R.id.loading_indicator_card);
        MaterialCardView nbCard = view.findViewById(R.id.navigation_bar_card);
        MaterialCardView nrCard = view.findViewById(R.id.navigation_rail_card);
        MaterialCardView piCard = view.findViewById(R.id.progress_indicators_card);
        MaterialCardView sCard = view.findViewById(R.id.sliders_card);
        MaterialCardView sbCard = view.findViewById(R.id.split_button_card);
        MaterialCardView tCard = view.findViewById(R.id.toolbar_card);

        abCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AppBarActivity.class);
            startActivity(intent);
        });

        bgCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ButtonGroupsActivity.class);
            startActivity(intent);
        });

        cbCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), CommonButtonActivity.class);
            startActivity(intent);
        });

        efCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ExtendedFABActivity.class);
            startActivity(intent);
        });

        fmCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FABMenuActivity.class);
            startActivity(intent);
        });

        fCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FABsActivity.class);
            startActivity(intent);
        });

        ibCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IconButtonActivity.class);
            startActivity(intent);
        });

        liCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoadingIndicatorActivity.class);
            startActivity(intent);
        });

        nbCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NavigationBarActivity.class);
            startActivity(intent);
        });

        nrCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NavigationRailActivity.class);
            startActivity(intent);
        });

        piCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProgressIndicatorsActivity.class);
            startActivity(intent);
        });

        sCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SlidersActivity.class);
            startActivity(intent);
        });

        sbCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SplitButtonActivity.class);
            startActivity(intent);
        });

        tCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ToolbarsActivity.class);
            startActivity(intent);
        });
    }
}