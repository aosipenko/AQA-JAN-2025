package org.prog.parent;

//TODO: add destination parameter to method goTo

import java.sql.Driver;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {

    public String color;
    public String ownerName;
//    public boolean obj;


    public Car(String color) {
        this.color = color;
    }
    public Object formatCarsList(List<Car> cars) {
        return cars.stream()
                .map(Car::getColor);
    }

//    private Object getColor() {
//        return color;
//
//    }

//    public Car(String color) {
//        this.color = color;
//    }

    public Car() {

    }
    private String name;

//    @Override
//    public boolean equals(Object obj) {
//  if (obj instanceof Car) {
//      Car c = (Car) obj;
//       boolean carColorsAreTheSame=this.color.equals(c.color)&&
//             Objects.equals(this.ownerName, c.ownerName);
//////            if (this.color != null) {
//////                return this.color.equals(c.color);
//////            } else
//     {
//         return carColorsAreTheSame;
//          }
//        }
//        return false;
//   }


//    @Override
//    public int hashCode() {
//        if (color != null) {
//            return color.hashCode();
//        }
//        return 0;
//    }


//    @Override
//    public String toString() {
//            return name;
//        }

    public void goTo() {
        goTo("anywhere");
    }

    public void goTo(String destination) {
        goTo(destination, "current location");
    }

    public void goTo(String destination, String startingFrom) {
        goTo(destination, startingFrom, "nowhere");
    }

    public void goTo(String destination, String startingFrom, String passingThrough) {
        System.out.println(color + " is driving from " + startingFrom + " to "
                + destination + " stopping at " + passingThrough);
    }


    public void turnSomewhere() {
        System.out.println("Car is turning somewhere");
    }

    public void isCarRed() {
        checkCarColor("red");
    }

    void defaultAccessMethod() {
        System.out.println("This is default visibility");
    }

    protected void thisIsOnlyForChildren() {
        System.out.println("Parent method!");
    }

    private void checkCarColor(String colorSample) {
        if (color != null) {
            System.out.println(color.equals(colorSample));
        }
        System.out.println("Car is not painted!");
    }
//
//
//
//        public String color;
//
//        public Car(String color) {
//            this.color = color;
//        }
//
//        public String getColor() {
//            return color;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) return true;
//            if (obj == null || getClass() != obj.getClass()) return false;
//            Car car = (Car) obj;
//            return Objects.equals(color, car.color);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(color);
//        }
//
//    class Driver {
//    public String name;
//    public Driver (String name) {
//        this.name = name;
//    }
//    public String getOwnerName(){
//        return name;
//    }
//
//    }




        public String model;
//        public String color;

//        public Car(String model, String color) {
//            this.model = model;
//            this.color = color;
//        }

//        public String getModel() {
//            return model;
//        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return color ;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Car car = (Car) obj;
            return Objects.equals(model, car.model) && Objects.equals(color, car.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(model, color);
        }
    }



