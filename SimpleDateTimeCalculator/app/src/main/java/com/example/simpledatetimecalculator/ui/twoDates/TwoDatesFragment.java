package com.example.simpledatetimecalculator.ui.twoDates;

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

public class TwoDatesFragment extends Fragment {

    private TwoDatesViewModel mTwoDatesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mTwoDatesViewModel =
                new ViewModelProvider(this).get(TwoDatesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_two_dates, container, false);
        final TextView textView = root.findViewById(R.id.text_two_dates_header);
        mTwoDatesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}