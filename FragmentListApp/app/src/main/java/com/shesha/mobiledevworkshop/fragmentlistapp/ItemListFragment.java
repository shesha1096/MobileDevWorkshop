package com.shesha.mobiledevworkshop.fragmentlistapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemListFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        textView = view.findViewById(R.id.item_text);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String itemDetail = arguments.getString("item");
            textView.setText(itemDetail);
        }
        return view;
    }
}