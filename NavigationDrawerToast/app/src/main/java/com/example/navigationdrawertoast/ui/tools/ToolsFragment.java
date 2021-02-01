package com.example.navigationdrawertoast.ui.tools;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawertoast.R;

public class ToolsFragment extends Fragment {
    private static final String LOG_TAG = ToolsFragment.class.getSimpleName();
    private ToolsViewModel mToolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInStanceState) {

        mToolsViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        mToolsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        this.ShowToast();
//        Log.d(LOG_TAG, "onOptionsItemSelected: TOAST??");
//        return super.onOptionsItemSelected(item);

//    }


    public void ShowToast() {
        Toast toast = new Toast(this.getContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText("Option was clicked");
        toast.show();
    }
}
