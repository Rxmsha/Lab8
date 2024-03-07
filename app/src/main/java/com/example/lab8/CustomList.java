package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }


    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * When given a city, return whether or not it belongs in the list
     * @param city
     * This is a candidate city to check if its in the list
     * @return
     * Return true if its found in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);

    }

    /**
     * Checks if the city is present in the list.
     * If it is, then remove it from the list, if not then throw an exception
     * @param city
     * This is a candidate city to delete
     */
    public void deleteCity(City city) {
        if (cities.contains(city))  {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    /**
     * this gets size of the list
     * @return
     */
    public int countCities(){


    }


}
