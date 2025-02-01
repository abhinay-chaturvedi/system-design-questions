package org.abhinay.traffic_system;

public class TrafficSystemDemo {
    public void run() {
        TrafficController trafficController = TrafficController.getInstance();

        // Create roads
        Road road1 = new Road("R1");
        Road road2 = new Road("R2");
        Road road3 = new Road("R3");
        Road road4 = new Road("R4");

        TrafficLight trafficLight1 = new TrafficLight(road1, 6000, 3000, 9000);
        TrafficLight trafficLight2 = new TrafficLight(road2, 6000, 3000, 9000);
        TrafficLight trafficLight3 = new TrafficLight(road3, 6000, 3000, 9000);
        TrafficLight trafficLight4 = new TrafficLight(road4, 6000, 3000, 9000);
        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);
        trafficController.addRaod(road1);
        trafficController.addRaod(road2);
        trafficController.addRaod(road3);
        trafficController.addRaod(road4);
        trafficController.startTraffic();
        trafficController.handleEmergency(road1);
    }
}
