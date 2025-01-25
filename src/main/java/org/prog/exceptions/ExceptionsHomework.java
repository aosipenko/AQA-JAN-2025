package org.prog.exceptions;



//TODO: write a method which ca cause NullPointerException
// TODO: write try-catc-finally to catch NPE
// TODO: on exception -> print "EXCEPTION CAUGHT!"
// TODO: always print "DONE TRY-CATCH-FINALLY"

import org.prog.parent.Car;

import java.io.FileNotFoundException;

public class ExceptionsHomework {

    public static void main(String[] args) {

        Object o= new Object();
        Car car1=new Car();
        Car car2=new Car();

//        car1.color="red";
//        car1.ownerName="John";
//
//        car2.color="red";
//        car2.ownerName="John";

        try {
        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        } catch(NullPointerException nullPointerException){
            System.out.println("EXCEPTION CAUGHT!");
        } finally {
            System.out.println("DONE TRY-CATCH-FINALLY");

        }
        System.out.println(car1.toString());
        System.out.println(car2.toString());

    }

}