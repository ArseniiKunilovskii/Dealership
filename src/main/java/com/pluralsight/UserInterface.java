package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);
    public UserInterface() {
    }
    public void display(){
        init();
        boolean done = false;

        // Main menu loop

        int choice = -1;
        while (choice != 99) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / mode");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1-9, or 99.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetByAllVehiclesRequest();
                case 8 -> processGetByAddVehicleRequest();
                case 9 -> processGetByRemoveVehicleRequest();
                case 99 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    private void init(){
        dealership = DealershipFileManager.getDealership();
    }
    public void  processGetByPriceRequest(){
        System.out.println("What is your minimum price?");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("What is your maximum price?");
        double max = scanner.nextDouble();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min,max));

    }
    public void  processGetByMakeModelRequest(){
        System.out.println("What is your make?");
        String make = scanner.nextLine();;

        System.out.println("What is your model?");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make,model));
    }
    public void  processGetByYearRequest(){
        System.out.println("What is your year?");
        int year = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(year));
    }
    public void  processGetByColorRequest(){
        System.out.println("What is your color?");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void  processGetByMileageRequest(){
        System.out.println("What is your mileage?");
        int year = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(year));
    }
    public void  processGetByVehicleTypeRequest(){
        System.out.println("What is your type?");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }
    public void  processGetByAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void  processGetByAddVehicleRequest(){
        System.out.println("Please enter vin");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter make");
        String make = scanner.nextLine();
        System.out.println("Please enter model");
        String model = scanner.nextLine();
        System.out.println("Please enter type");
        String type = scanner.nextLine();
        System.out.println("Please enter color");
        String color = scanner.nextLine();
        System.out.println("Please enter mileage");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        dealership.addVehicle(new Vehicle(vin, year,make,model,type,color,mileage,price));
        System.out.println(make+model+ " has been added");
    }
    public void  processGetByRemoveVehicleRequest(){
        System.out.println("Please enter the vin of car that you want to remove");
        int vin = scanner.nextInt();
        scanner.nextLine();
        for (Vehicle vehicle: dealership.getAllVehicles()){
            if(vehicle.getVin()==vin){
                System.out.println(vehicle.getMake()+ vehicle.getModel()+ " has been removed");
                dealership.removeVehicle(vehicle);
                break;
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle: vehicles) {
            String outputFormat = "| %-8d | %-6d | %-10s | %-15s | %-15s | %-10s | %8d | $%,12.2f |%n";
            System.out.printf(outputFormat, vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }
}
