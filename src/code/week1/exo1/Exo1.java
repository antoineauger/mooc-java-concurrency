package code.week1.exo1;

import graphique.Fenetre;

import java.awt.*;

/**
 * Created by an.auger on 29/04/2017.
 */
public class Exo1 {
    private Fenetre myWindow;

    public Exo1(Fenetre myWindow) {
        this.myWindow = myWindow;
    }

    public void runExo1Simple() {
        // Question 1
        myWindow.tracerLignePointAPoint(new Point(20,20), new Point(400,400));
        myWindow.tracerLignePointAPoint(new Point(400,400), new Point(20,400));
        myWindow.tracerLignePointAPoint(new Point(20,400), new Point(20,20));
    }

    public void runExo1Thread() {
        // Question 2
        DrawLineThread t1 = new DrawLineThread(myWindow, new Point(20,20), new Point(400,400));
        DrawLineThread t2 = new DrawLineThread(myWindow, new Point(400,400), new Point(20,400));
        DrawLineThread t3 = new DrawLineThread(myWindow, new Point(20,400), new Point(20,20));
        t1.start();
        t2.start();
        t3.start();
    }

    public void runExo1Runnable() {
        // Question 3
        DrawLineRunnable r1 = new DrawLineRunnable(myWindow, new Point(20,20), new Point(400,400));
        DrawLineRunnable r2 = new DrawLineRunnable(myWindow, new Point(400,400), new Point(20,400));
        DrawLineRunnable r3 = new DrawLineRunnable(myWindow, new Point(20,400), new Point(20,20));
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }
}
