package org.prog.poly.homework;

//TODO: Add interface IPhone
//TODO: Add interface method for call
//TODO: Add interface method for unlock
//TODO: Add class for Androind and iOS phones that implement IPhone

public class PolyHomework {

    public static void main(String[] args) {
        //TODO: create Android and IOS phones, and call usePhone() for both
        Android androidPhone = new Android();
        ISO isoPhone = new ISO();
        usePhone(androidPhone);
        usePhone(isoPhone);

    }

    public static void usePhone(IPhone iPhone) {
        iPhone.unlockPhone();
        iPhone.callToSomeone();
    }
}
