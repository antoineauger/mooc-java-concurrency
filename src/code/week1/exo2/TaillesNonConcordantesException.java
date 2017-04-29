package code.week1.exo2;

/**
 * Created by an.auger on 29/04/2017.
 */
public class TaillesNonConcordantesException extends Exception {
    public TaillesNonConcordantesException(){
        System.out.println("Dimensions of m1 and m2 do not match!");
    }
}
