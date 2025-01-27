package org.prog.collections;

//TODO: write collection of cars (MAP/SET/LIST)
//TODO: WHERE: CAR CAN HAVE NO OWNER
//TODO: WHERE: CAR CAN HAVE 1 OR MORE OWNERS
//TODO: Write method that will print all owners sharing car

import org.prog.parent.Car;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Car1 -> John
 * Car2 -> John, Jane
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
     String driver1 = "John";
     String driver2 = "Jane";
     String driver3 = "Peter";
     String driver4 = "Sarah";


     Map<String, List<String>> ownedCars = new HashMap<>();
     ownedCars.put(driver1, Arrays.asList("Red", "Black"));
     ownedCars.put(driver2, Arrays.asList("Blue", "Gray"));
     ownedCars.put(driver3, Arrays.asList("White", "Yellow"));
     ownedCars.put(driver4, Arrays.asList("Green", "Orange"));
     printDriverCars(ownedCars);


 }
    private static void printDriverCars(Map<String, List<String>> ownedCars) {
        for (Map.Entry<String, List<String>> entry : ownedCars.entrySet()) {
            System.out.println("Driver: " + entry.getKey() + ", Cars: " + String.join(", ", entry.getValue()));
        }
    }
}

