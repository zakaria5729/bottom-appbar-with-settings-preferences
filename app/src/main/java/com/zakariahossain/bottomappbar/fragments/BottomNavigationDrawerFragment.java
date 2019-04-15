package com.zakariahossain.bottomappbar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.zakariahossain.bottomappbar.R;
import com.zakariahossain.bottomappbar.interfaces.OnMyInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomNavigationDrawerFragment extends BottomSheetDialogFragment {

    private NavigationView navigationView;
    private OnMyInterface onMyInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationView = view.findViewById(R.id.navigation_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.default_fragment:
                        Toast.makeText(getContext(), "nav1", Toast.LENGTH_SHORT).show();
                        onMyInterface.onMyFragment(new DefaultFragment());
                        dismiss();
                        break;

                    case R.id.first_fragment:
                        Toast.makeText(getContext(), "nav2", Toast.LENGTH_SHORT).show();
                        onMyInterface.onMyFragment(new FirstFragment());
                        dismiss();
                        break;

                    case R.id.second_fragment:
                        Toast.makeText(getContext(), "nav3", Toast.LENGTH_SHORT).show();
                        onMyInterface.onMyFragment(new SecondFragment());
                        dismiss();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            onMyInterface = (OnMyInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implements OnMyInterface methods.");
        }
    }
}
