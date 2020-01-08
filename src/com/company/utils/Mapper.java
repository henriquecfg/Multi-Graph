package com.company.utils;

import com.company.models.City;
import com.company.models.Highway;
import com.company.models.Road;
import com.company.models.Route;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private List<City> cities = new ArrayList<>();

    public void addCity(City city){
        cities.add(city);
    }

    public void addOneWayRoute(Route route){
        int position = findCityByPosition(route.getSource());
        cities.get(position).addRoute(route);

    }

    public void addTwoWaysRoute(Route route){
        int position = findCityByPosition(route.getSource());
        cities.get(position).addRoute(route);

        position =findCityByPosition(route.getDestination());

        if (route instanceof Highway) {
            cities.get(position).addRoute(((Highway) route).getInverseClone());
        } else {
            cities.get(position).addRoute(((Road) route).getInverseClone());
        }
    }

    public int findCityByPosition(City city){
        return cities.indexOf(city);
    }

    public City findCityByName(String city){
        for(City c : cities){
            if(c.getName().equals(city))
                return c;
        }
        return null;
    }

    /**

     Constructors , getters, setters , hashCode , equals , toString

     **/

    public Mapper() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
