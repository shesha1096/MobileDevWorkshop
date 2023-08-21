package com.shesha.mobiledevworkshop.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shesha.mobiledevworkshop.recyclerview.adapters.RecyclerViewAdapter;
import com.shesha.mobiledevworkshop.recyclerview.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.recycler_view);
        initItemList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(itemList));
    }

    private void initItemList() {
        int size = 10;
        for (int i = 0; i< size; i++) {
            itemList.add(new Item("Title " + i,"Description " + i));
        }
    }
}