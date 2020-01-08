package com.company.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

    private Integer id;
    private String name;

    private List<Route> listOfRoutes = new ArrayList<>();

    public void addRoute(Route route){
        listOfRoutes.add(route);
    }


    /**

        Constructors , getters, setters , hashCode , equals , toString

    **/

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getListOfRoutes() {
        return listOfRoutes;
    }

    public void setListOfRoutes(List<Route> listOfRoutes) {
        this.listOfRoutes = listOfRoutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id) &&
                name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
