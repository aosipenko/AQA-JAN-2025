package org.prog.collections;

import org.prog.parent.Car;

import java.util.*;
import java.util.stream.Collectors;

// 1. bind one person to a single car
// 2. bind one person to multiple cars
// 3. add logic to count cars for specific person

//TODO: Make cars unique for each drive

public class MapsPractice {

    public static void main(String[] args) {
        String driver1 = "John";
        String driver2 = "Jane";
        String driver3 = "Joe";

        Map< String, Set<Car>> ownedCars=new HashMap<>();
        ownedCars.put(driver1, new HashSet<>());
        ownedCars.put(driver2, new HashSet<>());
        ownedCars.put(driver3, new HashSet<>());

//        Map<String, List<Car>> ownedCars = new HashMap<>();
//        ownedCars.put(driver1, new ArrayList<>());
//        ownedCars.put(driver2, new ArrayList<>());
//        ownedCars.put(driver3, new ArrayList<>());

        ownedCars.get(driver1).add(new Car("Red"));
        ownedCars.get(driver1).add(new Car("Red"));
        ownedCars.get(driver1).add(new Car("Red"));
        ownedCars.get(driver1).add(new Car("Red"));

        ownedCars.get(driver2).add(new Car("Blue"));
        ownedCars.get(driver2).add(new Car("Blue"));

        ownedCars.get(driver3).add(new Car("White"));

        countCarsForDriver(driver1, ownedCars);
        countCarsForDriver(driver2, ownedCars);
        countCarsForDriver(driver3, ownedCars);
    }
    List<String> colors = List.of("Red", "Blue", "Green");

    String result = colors.stream()
            .collect(Collectors.joining(", "));


    public static void countCarsForDriver (String driverName, Map<String, Set<Car>> cars)
    {Set<Car> ownedCars=cars.get(driverName);
        System.out.println(driverName + " has access to " + ownedCars.size() + " unique cars:" + ownedCars);
    }

//    public static void countCarsForDriver(String driverName, Map<String, List<Car>> cars) {
//        List<Car> carsOfOwner = cars.get(driverName);
//        System.out.println(driverName + " has access to " + carsOfOwner.size() + " cars");
//    }
}

