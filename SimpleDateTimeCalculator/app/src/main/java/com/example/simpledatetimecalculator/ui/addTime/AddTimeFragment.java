package com.example.simpledatetimecalculator.ui.addTime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.simpledatetimecalculator.R;

public class AddTimeFragment extends Fragment {

    private AddTimeViewModel mAddTimeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mAddTimeViewModel =
                new ViewModelProvider(this).get(AddTimeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_time, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        mAddTimeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}