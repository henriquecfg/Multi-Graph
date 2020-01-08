package com.company.models;

public class Highway extends Route {

    private double highwayToll;

    @Override
    public double getTimeTraveled() {
        return this.getDistance() / this.getSpeedLimit();
    }

    @Override
    public double getCost() {
        // Gasoline price ->  1,40€
        // Car spends  7 km/l if speed > 100 ,  and spends 6 km/l if speed < 100

        return this.getSpeedLimit() >= 100
                ? 1.4*(this.getDistance()/7.0) + highwayToll
                : 1.4*(this.getDistance()/6.0) + highwayToll;

    }


    /**

     Constructors , getters, setters , hashCode , equals , toString

     **/


    public Highway(Integer id, String name, double speedLimit, double distance, City source, City destination, double highwayToll) {
        super(id, name, speedLimit, distance, source, destination);
        this.highwayToll = highwayToll;
    }

    public double getHighwayToll() {
        return highwayToll;
    }

    public void setHighwayToll(double highwayToll) {
        this.highwayToll = highwayToll;
    }

    public Road getInverseClone(){
        return new Road(this.getId(), this.getName(), this.getSpeedLimit(), this.getDistance(), this.getDestination(), this.getSource(), highwayToll);
    }
}
