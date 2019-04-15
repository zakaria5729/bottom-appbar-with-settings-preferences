package com.zakariahossain.bottomappbar.fragments;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.zakariahossain.bottomappbar.R;
import com.zakariahossain.bottomappbar.settings.SettingsFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

public class DefaultFragment extends Fragment {

    private MaterialButton myButton;
    private AppCompatTextView myTextView;

    public DefaultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_default, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myTextView = view.findViewById(R.id.tv_default);
        myButton = view.findViewById(R.id.my_btn);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText(PreferenceManager.getDefaultSharedPreferences(getContext()).getString(SettingsFragment.PREF_SYNC_CONNECTION_TYPE, "Wifi"));

            }
        });
    }
}
