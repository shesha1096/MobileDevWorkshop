package com.shesha.mobiledevworkshop.navigationgraph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

// FirstFragment.java
public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
        });

        return view;
    }
}

