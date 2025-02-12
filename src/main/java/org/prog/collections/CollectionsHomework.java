package org.prog.collections;

//TODO: write collection of cars (MAP/SET/LIST)
//TODO: WHERE: CAR CAN HAVE NO OWNER
//TODO: WHERE: CAR CAN HAVE 1 OR MORE OWNERS
//TODO: Write method that will print all owners sharing car

import org.checkerframework.checker.units.qual.C;
import org.prog.cars.Car;

import java.util.*;

/**
 * Car1 -> John
 * Car2 -> John, Jane, KAte, Bob
 * Car3 -> Jane
 * Car4 ->
 * Car5 -> Sarah, Peter
 * Car6 -> Peter
 * Car7 -> Bob
 * Car8 -> Ivy
 * expected result: Peter, Sarah, John, Jane
 */

public class CollectionsHomework {

    public static void main(String[] args) {
        Car carOrange = new Car("orange");
        Car carGreen = new Car("green");
        Car carBlack = new Car("black");
        Car carPink = new Car("pink");
        Car carBlue = new Car("blue");
        Map<Car, List<String>> carsAndOwners = new HashMap<>();
        carsAndOwners.put(carBlue, new ArrayList<>());
        carsAndOwners.put(carBlack, new ArrayList<>());
        carsAndOwners.put(carGreen, new ArrayList<>());
        carsAndOwners.put(carOrange, new ArrayList<>());
        carsAndOwners.put(carPink, new ArrayList<>());

        carsAndOwners.get(carBlue).add("Tom");
        carsAndOwners.get(carBlue).add("Bob");

        carsAndOwners.get(carBlack).add("Tom");
        carsAndOwners.get(carBlack).add("Marta");

        carsAndOwners.get(carGreen).add("Kate");

        carsAndOwners.get(carOrange).add("Marta");
        carsAndOwners.get(carOrange).add("John");

        printOwnersWhichSharingCars(carsAndOwners);
    }

    public static void printOwnersWhichSharingCars(Map<Car, List<String>> carsAndOwners) {
        Set<Map.Entry<Car, List<String>>> cars = carsAndOwners.entrySet();
        Set<String> result = new HashSet<>();

        Iterator<Map.Entry<Car, List<String>>> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Car, List<String>> entry = iterator.next();
            List<String> owners = entry.getValue();
            if (owners.size() >= 2) {
                result.addAll(owners);
            }
        }

        for (String s : result) {
            System.out.print(s + " ");
        }

    }

}

