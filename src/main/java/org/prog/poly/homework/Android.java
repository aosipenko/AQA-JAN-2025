package org.prog.poly.homework;

public class Android implements IPhone {

    @Override
    public void unlockPhone() {
        System.out.println("The Android phone was unlocked");
    }

    @Override
    public void callToSomeone() {
        System.out.println("I was calling from Android phone");
    }
}
