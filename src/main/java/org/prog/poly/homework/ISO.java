package org.prog.poly.homework;

public class ISO implements IPhone {
    @Override
    public void unlockPhone() {
        System.out.println("The ISO phone was unlocked");
    }

    @Override
    public void callToSomeone() {
        System.out.println("I was calling from ISO phone");
    }
}
