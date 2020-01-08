package com.company;

import com.company.models.City;
import com.company.models.Highway;
import com.company.models.Road;
import com.company.models.Route;
import com.company.strategy.DistanceCost;
import com.company.strategy.MoneyCost;
import com.company.strategy.TimeCost;
import com.company.utils.Dijkstra;
import com.company.utils.Mapper;

public class Main {

    public static void main(String[] args) {
        City city1 = new City(0,"Sao Paulo");
        City city2 = new City(1,"Rio de Janeiro");
        City city3 = new City(2,"Minas Gerais");
        City city4 = new City(3,"Espirito Santo");
        City city5 = new City(4,"Parana");
        City city6 = new City(5,"Santa Catarina");

        Route route1 = new Road(0,"0",80,100, city1, city2, 2);
        Route route2 = new Highway(1,"1",130,110, city1, city3, 7);
        Route route3 = new Road(2,"2",85,100, city2, city4, 0);
        Route route4 = new Highway(3,"3",120,130, city3, city5, 8);
        Route route5 = new Road(4,"4",70,100, city4, city6, 0);
        Route route6 = new Highway(5,"5",120,100, city5, city6, 15);

        Mapper mapper = new Mapper();
        mapper.addCity(city1);mapper.addCity(city2);mapper.addCity(city3);
        mapper.addCity(city4);mapper.addCity(city5);mapper.addCity(city6);
        mapper.addOneWayRoute(route1);mapper.addOneWayRoute(route2);mapper.addOneWayRoute(route3);
        mapper.addOneWayRoute(route4);mapper.addOneWayRoute(route5);mapper.addOneWayRoute(route6);

        //DistanceCost
        //MoneyCost
        //TimeCost
        Dijkstra dij = new Dijkstra(mapper,"Sao Paulo","Santa Catarina", new DistanceCost());
        dij.findShortestWay();
        System.out.println(dij.StringValueOfTheWay());
        System.out.println();

        Dijkstra dij2 = new Dijkstra(mapper,"Sao Paulo","Santa Catarina", new MoneyCost());
        dij2.findShortestWay();
        System.out.println(dij2.StringValueOfTheWay());
        System.out.println();

        Dijkstra dij3 = new Dijkstra(mapper,"Sao Paulo","Santa Catarina", new TimeCost());
        dij3.findShortestWay();
        System.out.println(dij3.StringValueOfTheWay());
        System.out.println();

    }
}
