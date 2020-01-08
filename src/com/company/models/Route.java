package com.company.models;

import java.util.Objects;

public abstract class Route {

        private Integer id;
        private String name;
        private double speedLimit; // km / h
        private double distance;  // km

        private City source;
        private City destination;

        public abstract double getTimeTraveled();
        public abstract double getCost();

        /**

         Constructors , getters, setters , hashCode , equals , toString

         **/


        public Route(Integer id, String name, double speedLimit, double distance, City source, City destination) {
                this.id = id;
                this.name = name;
                this.speedLimit = speedLimit;
                this.distance = distance;
                this.source = source;
                this.destination = destination;
        }

        public Integer getId() {
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

        public double getSpeedLimit() {
                return speedLimit;
        }

        public void setSpeedLimit(double speedLimit) {
                this.speedLimit = speedLimit;
        }

        public double getDistance() {
                return distance;
        }

        public void setDistance(double distance) {
                this.distance = distance;
        }

        public City getSource() {
                return source;
        }

        public void setSource(City source) {
                this.source = source;
        }

        public City getDestination() {
                return destination;
        }

        public void setDestination(City destination) {
                this.destination = destination;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Route route = (Route) o;
                return Double.compare(route.speedLimit, speedLimit) == 0 &&
                        Double.compare(route.distance, distance) == 0 &&
                        id.equals(route.id) &&
                        name.equals(route.name) &&
                        source.equals(route.source) &&
                        destination.equals(route.destination);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, speedLimit, distance, source, destination);
        }

        @Override
        public String toString() {
                return "Route{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", speedLimit=" + speedLimit +
                        ", distance=" + distance +
                        ", source=" + source +
                        ", destination=" + destination +
                        '}';
        }
}
