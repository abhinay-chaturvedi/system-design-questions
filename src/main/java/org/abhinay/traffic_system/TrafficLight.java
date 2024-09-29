package org.abhinay.traffic_system;

public class TrafficLight {
    private final int id;
    private Signal signalState;
    private final Road road;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;
    public TrafficLight(Road road, int greenDuration, int redDuration, int yellowDuration) {
        this.road = road;
        this.id = generateId();
        this.signalState = Signal.RED;
        this.greenDuration = greenDuration;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
    }
    public void changeSignalState(Signal signalState) {
        this.signalState = signalState;
        notifyObserver();
    }

    private void notifyObserver() {
        System.out.println("Notifying the road");
        this.road.showTrafficStatus();
    }

    public int getId() {
        return id;
    }

    public Signal getSignalState() {
        return signalState;
    }

    public Road getRoad() {
        return road;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }


    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
