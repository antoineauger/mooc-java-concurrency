package code.week2.exo1;

import java.util.Random;

/**
 * Created by an.auger on 06/05/2017.
 */
public class Groupe implements Runnable {
    private static int MIN_WAIT = 200;
    private static int MAX_WAIT = 5000;

    private int id;
    private int nbPersonnes;
    private Random rand;
    private boolean annulResarvation;
    private Salle salle;

    public Groupe(int id, int nbPersonnes, Salle salle, Random rand, boolean annulResarvation) {
        this.id = id;
        this.rand = rand;
        this.nbPersonnes = nbPersonnes;
        this.annulResarvation = annulResarvation;
        this.salle = salle;
    }

    @Override
    public void run() {
        try {
            salle.reserver(id, nbPersonnes);
            Thread.yield();
            Thread.sleep(rand.nextInt((MAX_WAIT - MIN_WAIT) + 1) + MIN_WAIT);
            if (annulResarvation) {
                salle.annulerReservation(id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
