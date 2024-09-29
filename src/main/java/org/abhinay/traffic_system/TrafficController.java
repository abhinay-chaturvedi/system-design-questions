package org.abhinay.traffic_system;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private static TrafficController instance;
    private final Map<String, Road> roads;
    private TrafficController() {
        this.roads = new HashMap<>();
    }
    public static TrafficController getInstance() {
        if(instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }
    public void addRaod(Road road) {
        roads.put(road.getName(), road);
    }
    public void startTraffic() {
        for(Road road: roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            new Thread(() -> {
                while(true) {
                 try {
                     Thread.sleep(trafficLight.getRedDuration());
                     trafficLight.changeSignalState(Signal.GREEN);
                     Thread.sleep(trafficLight.getGreenDuration());
                     trafficLight.changeSignalState(Signal.YELLOW);
                     Thread.sleep(trafficLight.getYellowDuration());
                     trafficLight.changeSignalState(Signal.RED);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                }
            }).start();
        }
    }
    public void handleEmergency(Road r) {
        Road road = this.roads.get(r.getName());
        if(road == null) return ;
        TrafficLight trafficLight = road.getTrafficLight();
        trafficLight.changeSignalState(Signal.GREEN);
    }
}
