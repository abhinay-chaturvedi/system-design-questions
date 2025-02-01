package org.abhinay;

import org.abhinay.atm_machine.AtmMachine;
import org.abhinay.car_rental_system.CarRentalSystem;

import org.abhinay.coffee_vending_machine.CoffeeMachineDemo;

import org.abhinay.hotel_management_system.HotelManagementDemo;
import org.abhinay.linkdin.LinkdinSystemDemo;
import org.abhinay.logging_framework.*;
import org.abhinay.parking_lot.ParkingLotDemo;


import org.abhinay.pub_sub.PubSub;
import org.abhinay.stack_overflow.StackOverflowDemo;
import org.abhinay.task_management_system.*;
import org.abhinay.tic_tac_toe_game.TicTacToeGameDemo;

import org.abhinay.traffic_system.TrafficSystemDemo;
import org.abhinay.vending_machine.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void runParkingLotSystem(){
        ParkingLotDemo app = new ParkingLotDemo();
        app.run();
    }
    public void runVendingMachine() {
        VendingMachineDemo app = new VendingMachineDemo();
        app.run();
    }
    public void runStackOverflow() {
        StackOverflowDemo app = new StackOverflowDemo();
        app.run();
    }
    public void runLogger() {
        LoggerDemo app = new LoggerDemo();
        app.run();
    }
    public void runCoffeeMachine() {
        CoffeeMachineDemo app = new CoffeeMachineDemo();
        app.run();
    }
    public void runTrafficSystem() {
        TrafficSystemDemo app = new TrafficSystemDemo();
        app.run();
    }
    public void runTaskManagementSystem() {
        TaskManagementDemo app = new TaskManagementDemo();
        app.run();
    }
    public void runPubSub() {
        PubSub app = PubSub.getInstance();
        app.run();
    }
    public void ticToeGame() {
        TicTacToeGameDemo app = new TicTacToeGameDemo();
        app.run();
    }
    public void runCarRentalSystem() {
        CarRentalSystem app = CarRentalSystem.getInstance();
        app.run();
    }

    public void runAtmMachineSystem() {
        AtmMachine app = AtmMachine.getInstance();
        app.run();
    }
    public void runHotelManagementSystem() {
        HotelManagementDemo app = new HotelManagementDemo();
        app.run();
    }
    public void runLinkedinService() {
        LinkdinSystemDemo app = new LinkdinSystemDemo();
        app.run();
    }

    public static void main(String[] args) {
        System.out.println("hi there! This is the entry point for all the questions");
        Main entryPoint = new Main();
//        entryPoint.runParkingLotSystem();
//        entryPoint.runVendingMachine();
//        entryPoint.runStackOverflow();
//        entryPoint.runLogger();
//        entryPoint.runCoffeeMachine();
//        entryPoint.runTrafficSystem();
//        entryPoint.runTaskManagementSystem();
//        entryPoint.runPubSub();
//        entryPoint.ticToeGame();
//        entryPoint.runCarRentalSystem();
//        entryPoint.runAtmMachineSystem();
//        entryPoint.runHotelManagementSystem();
        entryPoint.runLinkedinService();

    }



}