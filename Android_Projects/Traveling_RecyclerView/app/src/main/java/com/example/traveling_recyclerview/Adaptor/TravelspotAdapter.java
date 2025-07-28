package com.example.traveling_recyclerview.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveling_recyclerview.Modal.TravelSpots;
import com.example.traveling_recyclerview.R;

import java.util.List;

public class TravelspotAdapter extends RecyclerView.Adapter<TravelspotAdapter.SpotViewHolder> {

    List<TravelSpots> spotsList;

    public TravelspotAdapter(List<TravelSpots> spotsList){
        this.spotsList = spotsList;
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.traveling_spots,parent, false);
        return new SpotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
        TravelSpots travelSpots = spotsList.get(position);
        holder.textView.setText(travelSpots.getSpotName());
        holder.textView1.setText(travelSpots.getSpotCountry());
        holder.imageView.setImageResource(travelSpots.getSpotimg());

    }

    @Override
    public int getItemCount() {

        if (spotsList != null){

            return spotsList.size();
        }
        return 0;
    }

    public static class SpotViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView1;
        ImageView imageView;

        public SpotViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.placeid);
            textView1 = itemView.findViewById(R.id.countryid);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
