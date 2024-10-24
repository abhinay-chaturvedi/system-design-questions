package org.abhinay;

import org.abhinay.atm_machine.AtmMachine;
import org.abhinay.car_rental_system.CarRentalSystem;
import org.abhinay.coffee_vending_machine.Coffee;
import org.abhinay.coffee_vending_machine.CoffeeMachine;
import org.abhinay.coffee_vending_machine.Payment;
import org.abhinay.hotel_management_system.HotelManagementDemo;
import org.abhinay.logging_framework.Config;
import org.abhinay.logging_framework.FileAppender;
import org.abhinay.logging_framework.LogLevel;
import org.abhinay.logging_framework.Logger;
import org.abhinay.parking_lot.Level;
import org.abhinay.parking_lot.ParkingLot;
import org.abhinay.parking_lot.ParkingSpot;
import org.abhinay.parking_lot.vehicle.Car;
import org.abhinay.parking_lot.vehicle.Motorcycle;
import org.abhinay.parking_lot.vehicle.Truck;
import org.abhinay.parking_lot.vehicle.VehicleType;
//import org.abhinay.stack_overflow.*;
import org.abhinay.pub_sub.PubSub;
import org.abhinay.task_management_system.*;
import org.abhinay.tic_tac_toe_game.TicTacToeGame;
import org.abhinay.traffic_system.Road;
import org.abhinay.traffic_system.TrafficController;
import org.abhinay.traffic_system.TrafficLight;
import org.abhinay.vending_machine.Coin;
import org.abhinay.vending_machine.Note;
import org.abhinay.vending_machine.Product;
import org.abhinay.vending_machine.VendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void runParkingLotSystem(){
        System.out.println("Running parking lot system!");
        ParkingLot parkingLot  = ParkingLot.getInstance();
        Level level1 = new Level(1, 4);
//        level1.setParkingSpot(new ParkingSpot(VehicleType.CAR, 1));
//        level1.setParkingSpot(new ParkingSpot(VehicleType.TRUCK, 2));
//        level1.setParkingSpot(new ParkingSpot(VehicleType.MOTORCYCLE, 3));
        Level level2 = new Level(2, 3);
//        level2.setParkingSpot(new ParkingSpot(VehicleType.CAR, 1));
//        level2.setParkingSpot(new ParkingSpot(VehicleType.TRUCK, 2));
//        level2.setParkingSpot(new ParkingSpot(VehicleType.MOTORCYCLE, 3));
        parkingLot.setLevel(level1);
        parkingLot.setLevel(level2);
        parkingLot.displayAvailability();
        Car car1 = new Car("123");
        Car car2 = new Car("124");
        Truck truck1 = new Truck("321");
        Truck truck2 = new Truck("421");
        Motorcycle motor1 = new Motorcycle("motor1");
        Motorcycle motor2 = new Motorcycle("motor2");
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(motor1);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck2);
        parkingLot.parkVehicle(motor2);
        parkingLot.unParkVehicle(car2);
        parkingLot.displayAvailability();
    }
    public void runVendingMachine() {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Product kurkure = new Product("kurkure", 5);
        Product milk = new Product("milk", 50);
        vendingMachine.inventory.addProduct(kurkure, 10);
        vendingMachine.inventory.addProduct(milk, 5);
        vendingMachine.selectProduct(milk);
//        vendingMachine.selectProduct(kurkure);
//        vendingMachine.addCoin(Coin.DIME);
//        vendingMachine.addNote(Note.TWENTY);
//        vendingMachine.addNote(Note.TWENTY);
//        vendingMachine.addNote(Note.TWENTY);
        vendingMachine.makePaymentNote(Note.TWENTY);
        vendingMachine.makePaymentNote(Note.TWENTY);
//        vendingMachine.makePaymentNote(Note.TWENTY);
        vendingMachine.dispenseProduct();;
        vendingMachine.returnChange();

    }
//    public void runStackOverflow() {
//        StackOverflow stackOverflow = StackOverflow.getInstance();
////        User user1 = new User();
////        stackOverflow.addUser(user1);
////        stackOverflow.addUser(user1);
//        User abhinay = stackOverflow.addUser("abhinay", "abhinay@example.com");
//        User nitesh = stackOverflow.addUser("nitesh", "nitesh@example.com");
//        User third = stackOverflow.addUser("third", "third@example.com");
//
//
//        Question javaQuestion = stackOverflow.addQuestion( "What is polymorphism in Java?",
//                "Can someone explain polymorphism in Java with an example?",abhinay,
//                new ArrayList<>(Arrays.asList("java", "oop")));
//
//
//        Answer niteshAnswer = stackOverflow.addAnswer(javaQuestion,
//                "Polymorphism in Java is the ability of an object to take on many forms...", nitesh);
//
//        // third comments on the question
//        stackOverflow.addComment("Great question! I'm also interested in learning about this.", third, javaQuestion);
//
//        // Alice comments on Bob's answer
//        stackOverflow.addComment("Thanks for the explanation! Could you provide a code example?", abhinay, niteshAnswer);
//
//        // Charlie votes on the question and answer
//        stackOverflow.vote(javaQuestion, 1, third);  // Upvote
//        stackOverflow.vote(niteshAnswer, 1, third);  // Upvote
//
//        // Alice accepts Bob's answer
//        stackOverflow.acceptAnswer(niteshAnswer);
//
//
//
//        // Print out the current state
//        System.out.println("Question: " + javaQuestion.getTitle());
//        System.out.println("Asked by: " + javaQuestion.getAuthor().getUsername());
//        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
//        System.out.println("Votes: " + javaQuestion.getVoteCount());
//        System.out.println("Comments: " + javaQuestion.getComments().size());
//        System.out.println("\nAnswer by " + niteshAnswer.getAuthor().getUsername() + ":");
//        System.out.println(niteshAnswer.getContent());
//        System.out.println("Votes: " + niteshAnswer.getVoteCount());
//        System.out.println("Accepted: " + niteshAnswer.isAccepted());
//        System.out.println("Comments: " + niteshAnswer.getComments().size());
//
//        System.out.println("\nUser Reputations:");
//        System.out.println("abhinay: " + abhinay.getReputation());
//        System.out.println("nitesh: " + nitesh.getReputation());
//        System.out.println("third: " + third.getReputation());
//
//        // Demonstrate search functionality
//        System.out.println("\nSearch Results for 'java':");
//        ArrayList<Question> searchResults = stackOverflow.searchQueston("java");
//        for (Question q : searchResults) {
//            System.out.println(q.getTitle());
//        }
//
//        System.out.println("\nSearch Results for 'python':");
//        searchResults = stackOverflow.searchQueston("python");
//        for (Question q : searchResults) {
//            System.out.println(q.getTitle());
//        }
//
//        // Demonstrate getting questions by user
//        System.out.println("\nBob's Questions:");
//        ArrayList<Question> abhinayQuestions = stackOverflow.getQuestionByUser(abhinay);
//        for (Question q : abhinayQuestions) {
//            System.out.println(q.getTitle());
//        }
//    }
    public void runLogger() {
        Logger logger = Logger.getInstance();
        logger.info("hi there!");
        Config config = new Config(LogLevel.DEBUG, new FileAppender("app.txt"));
        logger.setConfig(config);
        logger.debug("hi debug");
    }
    public void runCoffeeMachine() {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.displayMenu();
        Coffee coffee = coffeeMachine.selectCoffee("Latte");
        Payment payment = coffeeMachine.makePayment(coffee, 5.0);
        coffeeMachine.dispenseCoffee(coffee, payment);
    }
    public void runTrafficSystem() {
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
    public void runTaskManagementSystem() {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User(1, "John Doe", "john@example.com");
        User user2 = new User(2, "Jane Smith", "jane@example.com");
        Task task1 = new Task(1, "Task 1", "Description 1", new Date());
        task1.setAssignedUser(user1);
        task1.setPriority(Priority.LOW);
        Task task2 = new Task(2, "Task 2", "Description 2", new Date());
        task2.setAssignedUser(user2);
        task2.setPriority(Priority.MEDIUM);
        Task task3 = new Task(3, "Task 3", "Description 3", new Date());
        task3.setAssignedUser(user2);
        task3.setPriority(Priority.HIGH);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);
        List<Task> searchResults = taskManager.searchTask("Task 1");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }
        List<Task> filteredTasks = taskManager.filterTask(TaskStatus.PENDING, new Date(0), new Date(), Priority.LOW);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }
        taskManager.markTaskAsCompleted(task1);

        // Get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user2);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

    }
    public void runPubSub() {
        PubSub pubSub = PubSub.getInstance();
        pubSub.startPubSubSystem();
    }
    public void ticToeGame() {
        TicTacToeGame ticTacToeGame = TicTacToeGame.getInstance();
        ticTacToeGame.assignFirstChance(1);
        ticTacToeGame.play();
    }
    public void runCarRentalSystem() {
        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();
        carRentalSystem.runCarRentalSystem();
    }

    public void runAtmMachineSystem() {
        AtmMachine atmMachine = AtmMachine.getInstance();
        atmMachine.runSystem();
    }
    public void runHotelManagementSystem() {
        HotelManagementDemo app = new HotelManagementDemo();
        app.runSystem();
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
        entryPoint.runHotelManagementSystem();

    }



}