package org.prog.collections;



import org.prog.cars.Car;

import java.util.*;

// 1. bind one person to a single car
// 2. bind one person to multiple cars
// 3. add logic to count cars for specific person

//TODO: Make cars unique for each drive

public class MapsPractice {

    public static void main(String[] args) {
        String driver1 = "John";
        String driver2 = "Jane";
        String driver3 = "Joe";

        Map<String, Set<Car>> ownedCars = new HashMap<>();
        ownedCars.put(driver1, new HashSet<>());
        ownedCars.put(driver2, new HashSet<>());
        ownedCars.put(driver3, new HashSet<>());

        ownedCars.get(driver1).add(new Car("Red"));
        ownedCars.get(driver1).add(new Car("Blue"));
        ownedCars.get(driver1).add(new Car("Black"));
        ownedCars.get(driver1).add(new Car("Purple"));

        ownedCars.get(driver2).add(new Car("Blue"));
        ownedCars.get(driver2).add(new Car("Yellow"));

        ownedCars.get(driver3).add(new Car("White"));

        printColorsOfCarsForDriver(driver1, ownedCars);
        printColorsOfCarsForDriver(driver2, ownedCars);
        printColorsOfCarsForDriver(driver3, ownedCars);
    }

    public static void printColorsOfCarsForDriver(String driverName, Map<String, Set<Car>> cars) {
        Set<Car> carsOfOwner = cars.get(driverName);
        for(Car car: carsOfOwner){
            System.out.println(driverName + " has unique cars: " + car.color);
        }
    }
}
