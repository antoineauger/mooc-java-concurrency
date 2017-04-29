package code;

import code.week1.exo2.MatriceEntiere;
import code.week1.exo2.TaillesNonConcordantesException;
import code.week1.exo2.TestProduitParallele;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
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

        try {

            MatriceEntiere m = new MatriceEntiere(3, 3);
            MatriceEntiere m1 = new MatriceEntiere(new File("data/matrix3x2.txt"));
            MatriceEntiere m2 = new MatriceEntiere(new File("data/matrix2x3.txt"));

            TestProduitParallele testProduitParallele = new TestProduitParallele(m, m1, m2);

        } catch (FileNotFoundException | TaillesNonConcordantesException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
