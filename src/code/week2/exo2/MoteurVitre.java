package code.week2.exo2;

import java.util.Random;

/**
 * Created by an.auger on 06/05/2017.
 */
public class MoteurVitre implements Runnable {
    private static int MIN_WAIT = 1000;
    private static int MAX_WAIT = 5000;

    private CoteVoiture coteVoiture;
    private PositionVitre positionVitre;
    private ActionSurVitre currActionSurVitre;
    private ActionSurVitre actionDemandee;
    private long attenteDuree;

    public MoteurVitre(CoteVoiture c) {
        Random rand = new Random(10);
        this.attenteDuree = rand.nextInt((MAX_WAIT - MIN_WAIT) + 1) + MIN_WAIT;
        this.coteVoiture = c;
        this.positionVitre = PositionVitre.HAUTE;
        this.currActionSurVitre = ActionSurVitre.NIL;
        this.actionDemandee = ActionSurVitre.NIL;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!actionDemandee.equals(ActionSurVitre.NIL)) {
                    System.out.println(actionDemandee.toString() + " pour le moteur vitre cote " + coteVoiture.toString());
                    currActionSurVitre = actionDemandee;
                    simulerAttente();
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public PositionVitre getPositionVitre() {
        return positionVitre;
    }

    public synchronized void simulerAttente() {
        try {
            System.out.println("Attente pour le moteur vitre cote " + coteVoiture.toString() + " (en train de " + actionDemandee + ").");
            Thread.sleep(attenteDuree);
            if (currActionSurVitre.equals(ActionSurVitre.MONTER)) {
                positionVitre = PositionVitre.HAUTE;
            }
            else if (currActionSurVitre.equals(ActionSurVitre.DESCENDRE)) {
                positionVitre = PositionVitre.BASSE;
            }
            System.out.println("Vitre cote " + coteVoiture.toString() + " en position " + positionVitre);

            currActionSurVitre = ActionSurVitre.NIL;
            actionDemandee = ActionSurVitre.NIL;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void demander(ActionSurVitre actionDemandee) {
        if (this.actionDemandee.equals(ActionSurVitre.NIL)) {
            this.actionDemandee = actionDemandee;
        }
    }
}
