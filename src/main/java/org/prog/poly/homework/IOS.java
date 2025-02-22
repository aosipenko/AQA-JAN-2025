package org.prog.poly.homework;

public class IOS implements IPhone {

    @Override
    public void call() {
        System.out.println("IPhone phone call");
    }

    @Override
    public void unlock() {
        System.out.println("IPhone phone unlock");
    }
}
