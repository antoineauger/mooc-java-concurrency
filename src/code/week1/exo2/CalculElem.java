package code.week1.exo2;

/**
 * Created by an.auger on 29/04/2017.
 */
public class CalculElem implements Runnable {
    private MatriceEntiere m;
    private int i;
    private int j;
    private MatriceEntiere m1;
    private MatriceEntiere m2;

    public CalculElem(MatriceEntiere m,
                      int i,
                      int j,
                      MatriceEntiere m1,
                      MatriceEntiere m2) {
        this.m = m;
        this.i = i;
        this.j = j;
        this.m1 = m1;
        this.m2 = m2;
    }

    @Override
    public void run() {
        try {
            m.setElem(i, j, MatriceEntiere.produitLigneColonne(m1, i, m2, j));
        } catch (TaillesNonConcordantesException e) {
            e.printStackTrace();
        }
    }
}
