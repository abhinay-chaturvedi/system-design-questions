package org.abhinay.traffic_system;

public class Road {
    private final int id;
    private final String name;
    private TrafficLight trafficLight;

    public Road(String name) {
        this.id = generateId();
        this.name = name;
    }
    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
    public void showTrafficStatus() {
        System.out.println("Here is the Traffic status of " + this.name + " - " + this.trafficLight.getSignalState());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
