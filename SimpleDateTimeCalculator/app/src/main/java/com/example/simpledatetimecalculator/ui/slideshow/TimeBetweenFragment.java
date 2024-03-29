package com.example.simpledatetimecalculator.ui.slideshow;

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

public class TimeBetweenFragment extends Fragment {

    private TimeBetweenViewModel mTimeBetweenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mTimeBetweenViewModel =
                new ViewModelProvider(this).get(TimeBetweenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time_between, container, false);
        final TextView textView = root.findViewById(R.id.text_time_between);
        mTimeBetweenViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}