package code.week1.exo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by an.auger on 29/04/2017.
 */
public class MatriceEntiere {
    private int[][] mat;
    private int nbLines;
    private int nbColumns;

    public MatriceEntiere(int lines, int columns) {
        this.mat = new int[lines][columns];
        this.nbLines = lines;
        this.nbColumns = columns;
    }

    public MatriceEntiere(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        String[] dim = scanner.nextLine().split(" ");
        this.nbLines = Integer.valueOf(dim[0]);
        this.nbColumns = Integer.valueOf(dim[1]);
        this.mat = new int[nbLines][nbColumns];

        for (int r=0 ; r<nbLines ; r++) {
            String[] oneLine = scanner.nextLine().split(" ");
            for (int c=0 ; c<nbColumns ; c++) {
                this.mat[r][c] = Integer.valueOf(oneLine[c]);
            }
        }

        scanner.close();
    }

    public int getElem(int i, int j) {
        return mat[i][j];
    }

    public void setElem(int i, int j, int val) {
        mat[i][j] = val;
    }

    public int getNbLines() {
        return nbLines;
    }

    public int getNbColumns() {
        return nbColumns;
    }

    public static int produitLigneColonne(MatriceEntiere m1, int i, MatriceEntiere m2, int j) throws TaillesNonConcordantesException {
        int result = 0;

        if (m1.getNbColumns() != m2.getNbLines()) {
            throw new TaillesNonConcordantesException();
        }

        int nbElems = m1.getNbColumns();
        for (int e=0 ; e<nbElems ; e++) {
            result += m1.getElem(i, e) * m2.getElem(e, j);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int r=0 ; r<getNbLines() ; r++) {
            for (int c=0 ; c<getNbColumns() ; c++) {
                stringBuilder
                        .append(String.valueOf(mat[r][c]))
                        .append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
