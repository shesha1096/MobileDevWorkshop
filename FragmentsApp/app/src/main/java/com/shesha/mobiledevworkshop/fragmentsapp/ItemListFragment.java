package com.shesha.mobiledevworkshop.fragmentsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemListFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_item, container, false);
        textView = rootView.findViewById(R.id.detailsTextView);
        Bundle args = getArguments();
        if (args != null) {
            String itemDetail = args.getString("title");
            textView.setText(itemDetail);
        }
        return rootView;
    }


}
