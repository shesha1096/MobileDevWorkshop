package com.shesha.mobiledevworkshop.roomdatabaseapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shesha.mobiledevworkshop.roomdatabaseapp.provider.Car;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public static final String TAG ="Workshop Day 3" ;
    List<Car> db = new ArrayList<>();

    public void setNewData(List< Car> newDb) {
        db = newDb;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_card, parent, false); //CardView inflated as RecyclerView list item
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car item =db.get(position);
        holder.makerTV.setText(item.getMaker());
        holder.modelTv.setText(item.getModel());
        holder.yearTv.setText(item.getYear()+"");
        holder.colorTv.setText(item.getColor());
        holder.seatsTv.setText(item.getSeats()+"");
        holder.priceTv.setText(item.getPrice()+"");
        Log.d(TAG,"onbind position "+position);
    }

    @Override
    public int getItemCount() {
        int size = (db == null) ? 0 : db.size();
        Log.d(TAG,"getCount size "+size);

        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView makerTV;
        TextView modelTv;
        TextView yearTv;
        TextView colorTv;
        TextView seatsTv;
        TextView priceTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            makerTV = itemView.findViewById(R.id.card_item_maker);
            modelTv = itemView.findViewById(R.id.card_item_model);
            yearTv = itemView.findViewById(R.id.card_item_year);
            colorTv = itemView.findViewById(R.id.card_item_color);
            priceTv = itemView.findViewById(R.id.card_item_price);
            seatsTv = itemView.findViewById(R.id.card_item_seat);
        }
    }
}
