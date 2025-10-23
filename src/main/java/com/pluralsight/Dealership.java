package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();
            if (price <= max && price >= min) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            String curMake = vehicle.getMake();
            String curModel = vehicle.getModel();
            if (curMake.equalsIgnoreCase(make) && curModel.equalsIgnoreCase(model)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

}
