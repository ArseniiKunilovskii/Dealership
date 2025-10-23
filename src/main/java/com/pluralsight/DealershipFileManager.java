package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    public static Dealership loadInventory(String fileName) {
        try {
            Dealership dealership;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            line = reader.readLine();
            String[] dealershipArray = line.split("\\|");
            dealership = new Dealership(dealershipArray[0], dealershipArray[1],dealershipArray[2]);
            while ((line = reader.readLine()) != null) {
                String[] vehicleArray = line.split("\\|");
                dealership.addVehicle(new Vehicle(Integer.parseInt(vehicleArray[0]), Integer.parseInt(vehicleArray[1]),vehicleArray[2], vehicleArray[3],vehicleArray[4], vehicleArray[5],Integer.parseInt(vehicleArray[6]),Double.parseDouble(vehicleArray[7])));
            }
            return dealership;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Data Error: A line in the file is corrupt or incomplete.");
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File is not found");
        } catch (java.io.IOException e){
            System.err.println("An unexpected error occurred while reading the file.");
        }
        return null;
    }
    public void saveDealership(Dealership dealership){

    }
}
