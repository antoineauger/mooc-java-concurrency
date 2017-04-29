package code.week1.exo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by an.auger on 29/04/2017.
 */
public class TestProduitParallele {
    public TestProduitParallele(MatriceEntiere m,
                                MatriceEntiere m1,
                                MatriceEntiere m2) throws TaillesNonConcordantesException, InterruptedException {

        if (m.getNbLines() != m1.getNbLines() || m.getNbColumns() != m2.getNbColumns()) {
            throw new TaillesNonConcordantesException();
        }

        List<Thread> allThreads = new ArrayList<>();

        // For all elements of the matrix m, we perform a parallel computation using CalculElem
        for (int i=0 ; i<m.getNbLines() ; i++) {
            for (int j=0 ; j<m.getNbLines() ; j++) {
                CalculElem c = new CalculElem(m, i, j, m1, m2);
                Thread t = new Thread(c);
                allThreads.add(t);
                t.start();
            }
        }

        // We wait for the completion of all threads
        for (Thread t : allThreads) {
            t.join();
        }

        // We print the result
        System.out.println(m.toString());
    }
}
