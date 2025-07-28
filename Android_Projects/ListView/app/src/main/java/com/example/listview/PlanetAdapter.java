package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> PlanetarrayList;
    Context context;


    public PlanetAdapter(@NonNull ArrayList<Planet> PlanetarrayList , Context context) {

        super(context, R.layout.planet_listview,PlanetarrayList);
        this.PlanetarrayList = PlanetarrayList;
        this.context = context;

    }

    private static class MyViewHolder

    {
        TextView planetName;
        TextView moonCount;
        ImageView planetImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Planet planet = getItem(position);

        MyViewHolder viewHolder;
        final View result;

        if(convertView == null){
            viewHolder = new MyViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.planet_listview, parent, false);

            viewHolder.planetName = convertView.findViewById(R.id.planetname);
            viewHolder.moonCount = convertView.findViewById(R.id.mooncnt);
            viewHolder.planetImage = convertView.findViewById(R.id.earthimg);

            result = convertView;
            convertView.setTag(viewHolder);

        }
        else
        {
            viewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;

        }

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.planetImage.setImageResource(planet.getImg());

        return result;
    }
}
