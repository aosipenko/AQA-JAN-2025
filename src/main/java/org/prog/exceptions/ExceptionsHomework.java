package org.prog.exceptions;


//TODO: write a method which ca cause NullPointerException
// TODO: write try-catc-finally to catch NPE
// TODO: on exception -> print "EXCEPTION CAUGHT!"
// TODO: always print "DONE TRY-CATCH-FINALLY"
public class ExceptionsHomework {

    public static void main(String[] args) {
        System.out.println(compareToColors(null, null));
    }

    public static boolean compareToColors(String oneColor, String twoColor) {
        try {
            return oneColor.equals(twoColor);
        } catch (NullPointerException ex) {
            System.out.println("EXCEPTION CAUGHT!");
        } finally {
            System.out.println("DONE TRY-CATCH-FINALLY");
        }
        return false;
    }
}
