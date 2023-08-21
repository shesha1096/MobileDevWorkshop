package com.shesha.mobiledevworkshop.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shesha.mobiledevworkshop.recyclerview.R;
import com.shesha.mobiledevworkshop.recyclerview.models.Item;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerItemView> {

    private List<Item> itemList;

    public RecyclerViewAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
        return new RecyclerItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemView holder, int position) {
        holder.titleTextView.setText(itemList.get(position).getTitle());
        holder.descriptionTextView.setText(itemList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class RecyclerItemView extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView descriptionTextView;

        public RecyclerItemView(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }
}
