package com.company.models;

public class Road extends Route {

    private double traffic; // hours  (arbitrary)

    @Override
    public double getTimeTraveled() {
        return traffic + this.getDistance() / this.getSpeedLimit();
    }

    @Override
    public double getCost() {
        // Gasoline price ->  1,40€  (arbitrary)
        // Car spends  7 km/l if speed > 100 ,  and spends 6 km/l if speed < 100 (arbitrary)

        return this.getSpeedLimit() >= 100
                ? 1.4*(this.getDistance()/7.0)
                : 1.4*(this.getDistance()/6.0);
    }

    /**

     Constructors , getters, setters , hashCode , equals , toString

     **/


    public Road(Integer id, String name, double speedLimit, double distance, City source, City destination, double traffic) {
        super(id, name, speedLimit, distance, source, destination);
        this.traffic = traffic;
    }

    public double getTraffic() {
        return traffic;
    }

    public void setTraffic(double traffic) {
        this.traffic = traffic;
    }

    public Road getInverseClone(){
        return new Road(this.getId(), this.getName(), this.getSpeedLimit(), this.getDistance(), this.getDestination(), this.getSource(), traffic);
    }
}
