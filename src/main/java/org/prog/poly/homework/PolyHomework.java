package org.prog.poly.homework;

//TODO: Add interface IPhone
//TODO: Add interface method for call
//TODO: Add interface method for unlock
//TODO: Add class for Androind and iOS phones that implement IPhone

public class PolyHomework {

    public static void main(String[] args) {
        //TODO: create Android and IOS phones, and call usePhone() for both
        IOS iPhone = new IOS();
        Android samsung = new Android();

        usePhone(iPhone);
        usePhone(samsung);
    }

    public static void usePhone(IPhone phone) {
       phone.unlock();
       phone.call();
    }
}
