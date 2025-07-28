package com.example.countryslist.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryslist.Modal.CountryList;
import com.example.countryslist.R;

import java.util.List;
import java.util.zip.Inflater;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryviewHolder>{

    List<CountryList>  countryLists;

    public CountryListAdapter(List<CountryList> countryLists){
        this.countryLists = countryLists;
    }

    @NonNull
    @Override
    public CountryviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listof_country, parent, false);
        return new CountryviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryviewHolder holder, int position) {

        CountryList listOfCountry = countryLists.get(position);

        holder.textView.setText(listOfCountry.getName());
        holder.imageView.setImageResource(listOfCountry.getImg());
    }

    @Override
    public int getItemCount() {

        if (countryLists != null){

            return countryLists.size();

        }
        return 0;
    }

    public static class CountryviewHolder extends RecyclerView.ViewHolder{


        TextView textView;
        ImageView imageView;

        public CountryviewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }


}
