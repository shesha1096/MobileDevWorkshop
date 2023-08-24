package com.shesha.mobiledevworkshop.fragmentlistapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends Fragment {
    private ListView listView;
    private OnItemClickListener onItemClickListener;

    public ListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.list_items);
        String[] items = new String[10];
        for (int i = 0; i < 10; i++) {
            items[i] = "Item: " + (i+1);
        }
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = items[position];
                onItemClickListener.onItemClick(selectedItem);
            }
        });
        return  view;
    }

    public interface OnItemClickListener {
        void onItemClick(String selectedItem);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onItemClickListener = (OnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " Must implement the onClickListener");
        }
    }
}