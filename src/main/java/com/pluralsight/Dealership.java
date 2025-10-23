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

    public ArrayList<Vehicle> getVehiclesByYear(int year){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            int curYear = vehicle.getYear();
            if (curYear==year) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            int mileage = vehicle.getOdometer();
            if (mileage <= max && mileage >= min) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehiclesByType(String type){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            String curType = vehicle.getVehicleType();
            if (curType.equalsIgnoreCase(type)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            String curColor = vehicle.getColor();
            if (curColor.equalsIgnoreCase(color)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
