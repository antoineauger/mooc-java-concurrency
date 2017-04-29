package code.week1.exo1;

import graphique.Fenetre;

import java.awt.*;

/**
 * Created by an.auger on 27/04/2017.
 */
public class DrawLineRunnable implements Runnable {
    private Fenetre myWindow;
    private Point point1;
    private Point point2;

    public DrawLineRunnable(Fenetre myWindow, Point point1, Point point2) {
        this.myWindow = myWindow;
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public void run() {
        myWindow.tracerLignePointAPoint(point1, point2);
    }
}
