package com.company.utils;

import com.company.strategy.CostType;
import com.company.models.City;
import com.company.models.Route;

import java.util.*;

public class Dijkstra {

    private Mapper mapper;
    private City source;
    private City destination;
    private CostType costType;

    Map<City, Map<City, Route>> way = new LinkedHashMap<>();

    public Dijkstra(Mapper mapper, String source, String destination, CostType costType) {
        super();
        this.mapper = mapper;
        this.source = mapper.findCityByName(source);
        this.destination = mapper.findCityByName(destination);
        this.costType = costType;
    }

    private List<Double> maximizeWeights(){
        List<Double> weights = new ArrayList<>();

        for(int i = 0; i < mapper.getCities().size() ; i++){
            weights.add(Double.MAX_VALUE/2);
        }
        weights.set(mapper.findCityByPosition(this.source), 0D);
        return weights;
    }

    public void findShortestWay(){


        Set<City> citiesAlreadyVisited = new HashSet<>();

        List<Double> weights = maximizeWeights();

        List<City> listOfPossibleCities = new ArrayList<>();
        listOfPossibleCities.add(source);

        while(!listOfPossibleCities.isEmpty()){

            City actualCity = choiceOfTheLightest(listOfPossibleCities , weights);
            listOfPossibleCities.remove(actualCity);

            for(Route actualRoute : actualCity.getListOfRoutes()){
                City dest = actualRoute.getDestination();

                if(citiesAlreadyVisited.contains(dest)){
                    continue;
                }else if(!listOfPossibleCities.contains(dest)){
                    listOfPossibleCities.add(dest);
                }


                double actualWeight = weights.get(actualCity.getId()) + costType.getCost(actualRoute);

                if(actualWeight < weights.get(dest.getId())){
                    weights.set(dest.getId(), actualWeight);
                    Map<City,Route> auxiliar = new HashMap<>();
                    auxiliar.put(actualCity, actualRoute);
                    way.put(dest, auxiliar);
                }
            }
            citiesAlreadyVisited.add(actualCity);
        }
    }

    private City choiceOfTheLightest(List<City> listOfPossibleCities, List<Double> weights){

        City actualCity = new City();

        double lower = Double.MAX_VALUE;

        for(City lowerWeight : listOfPossibleCities){
            if( weights.get(lowerWeight.getId()) < lower){
                lower = weights.get(lowerWeight.getId());
                actualCity = lowerWeight;
            }
        }
        return actualCity;
    }

    public String StringValueOfTheWay(){

        String text = "";
        String textReverse = "";
        String aux;
        text += "Better way between " + source.getName() + " and " +destination.getName();

        Map<City,Route> traceBack = way.get(destination);
        float totalCost = 0;
        float totalTime = 0;
        float totalDistance = 0;



        while(traceBack != null){

            for (Map.Entry<City, Route> entry : traceBack.entrySet()) {
                City key = entry.getKey();
                Route value = entry.getValue();

                aux = "\n- "+ value.getName() + " from " + key.getName() + " to " + value.getDestination().getName();
                textReverse =  aux + textReverse;

                totalCost += value.getCost();
                totalTime += value.getTimeTraveled();
                totalDistance += value.getDistance();

                traceBack = way.get(key);
            }
        }


        text += textReverse;
        text += "\n Duration: " + formatTime(totalTime);
        text += "\n Distance : " + totalDistance + " km";

        totalCost *= 100;
        totalCost = Math.round(totalCost);
        totalCost /= 100;
        text += "\n Cost in euros : " + totalCost;

        if(totalDistance == 0){
            if( source.getName().equals(destination.getName()))
                text = "Invalide Way";
            else text = "You are already there";
        }
        return text;
    }

    private String formatTime(float time){

        int aux = (int) Math.floor(time);
        String h = String.valueOf(aux);

        int minute = (int) Math.floor((time - aux)*60);
        String m = String.valueOf(minute);

        int seg = (int) Math.round(((time - aux)*60 -minute)*60);
        String s = String.valueOf(seg);

        return " "+h+"h "+m+"mn "+s+"s";
    }
}
