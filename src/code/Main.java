package code;

import code.week2.exo1.Salle;
import code.week2.exo1.TestReservation;
import code.week2.exo2.ActionSurVitre;
import code.week2.exo2.CoteVoiture;
import code.week2.exo2.MoteurVitre;
import code.week2.exo2.PositionVitre;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Week 1

        /**
         * Exercise 1
         */

        // Fenetre myWindow = new Fenetre(800, 600, "MOOC - TP Semaine 1");
        // Exo1 exo1 = new Exo1(myWindow);
        // exo1.runExo1Simple();
        // exo1.runExo1Thread();
        // exo1.runExo1Runnable();

        // --------------------------------------------------------------------- //

        /**
         * Exercise 2
         */

        // try {

        //    MatriceEntiere m = new MatriceEntiere(3, 3);
        //    MatriceEntiere m1 = new MatriceEntiere(new File("data/matrix3x2.txt"));
        //    MatriceEntiere m2 = new MatriceEntiere(new File("data/matrix2x3.txt"));

        //    TestProduitParallele testProduitParallele = new TestProduitParallele(m, m1, m2);

        // } catch (FileNotFoundException | TaillesNonConcordantesException | InterruptedException e) {
        //    e.printStackTrace();
        // }

        // --------------------------------------------------------------------- //
        // --------------------------------------------------------------------- //

        // Week 2

        /**
         * Exercise 1
         */

        // Random rand = new Random(10);
        // Salle testSalle = new Salle(5, 12);
        // TestReservation testReservation = new TestReservation(testSalle, rand);

        /**
         * Exercise 2
         */

        MoteurVitre m1 = new MoteurVitre(CoteVoiture.GAUCHE);
        MoteurVitre m2 = new MoteurVitre(CoteVoiture.DROITE);

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);

        t1.start();
        t2.start();

        if (m1.getPositionVitre().equals(PositionVitre.HAUTE)) {
            m1.demander(ActionSurVitre.DESCENDRE);
        }
        if (m2.getPositionVitre().equals(PositionVitre.HAUTE)) {
            m2.demander(ActionSurVitre.DESCENDRE);
        }

    }
}
