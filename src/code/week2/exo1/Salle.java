package code.week2.exo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by an.auger on 06/05/2017.
 */
public class Salle {
    private class Place {
        int rang;
        int place;
        public Place(int rang, int place) {
            this.rang = rang;
            this.place = place;
        }
    }

    private int nbRangs;
    private int nbPlacesParRang;
    private boolean[][] planSalle;
    private Map<Integer, List<Place>> placesGroupes;

    public Salle(int nbRangs, int nbPlacesParRang) {
        this.nbRangs = nbRangs;
        this.nbPlacesParRang = nbPlacesParRang;

        this.planSalle = new boolean[nbRangs][nbPlacesParRang];
        for (int i=0 ; i<nbRangs ; i++) {
            for (int j=0 ; j<nbPlacesParRang ; j++) {
                this.planSalle[i][j] = true;
            }
        }

        this.placesGroupes = new HashMap<>();
    }

    public boolean capaciteOK(int n) {
        int compteur = 0;
        for (int i=0 ; i<nbRangs ; i++) {
            for (int j=0 ; j<nbPlacesParRang ; j++) {
                if (planSalle[i][j]) {
                    compteur += 1;
                    if (compteur == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int nContiguesAuRangI(int n, int i){
        int compteur = 0;
        int startIndex = -1;
        for (int j=0 ; j<nbPlacesParRang ; j++) {
            if (planSalle[i][j]) {
                if (startIndex == -1) {
                    startIndex = j;
                }
                compteur += 1;
                if (compteur == n) {
                    return startIndex;
                }
            }
            else {
                compteur = 0;
                startIndex = -1;
            }
        }
        return -1;
    }

    public synchronized boolean reserverContigues(int id, int n) {
        for (int i=0 ; i<nbRangs ; i++) {
            int startIndex = nContiguesAuRangI(n, i);
            if (startIndex != -1) {
                placesGroupes.put(id, new ArrayList<>());
                for (int k=startIndex ; k<startIndex+n ; k++) {
                    planSalle[i][k] = false;
                    placesGroupes.get(id).add(new Place(i, k));
                }
                System.out.println("Reservation contigue effectuee pour le groupe " + String.valueOf(id) +
                        " (" + String.valueOf(n) + " personnes). " +
                        "Rang " + String.valueOf(i) + " / places " + String.valueOf(startIndex) +
                        " à " + String.valueOf(startIndex + n - 1) + ".");
                return true;
            }
        }
        return false;
    }

    public synchronized boolean reserver(int id, int n) {
        int compteur = 0;
        if (capaciteOK(n)) {
            if (reserverContigues(id, n)) { // TestReservation contigue
                return true;
            }
            else { // TestReservation non-contigue
                placesGroupes.put(id, new ArrayList<>());
                for (int i=0 ; i<nbRangs ; i++) {
                    for (int j=0 ; j<nbPlacesParRang ; j++) {
                        if (planSalle[i][j]) {
                            planSalle[i][j] = false;
                            placesGroupes.get(id).add(new Place(i, j));
                            compteur += 1;
                            if (compteur == n) {
                                System.out.println("Reservation non contigue realisee pour le groupe " + id + " (" + n + " personnes).");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Reservation impossible pour le groupe " + id + " (" + n + " personnes).");
        return false;
    }

    public synchronized boolean annulerReservation(int id) {
        StringBuilder s = new StringBuilder();
        for (Place p : placesGroupes.get(id)) {
            planSalle[p.rang][p.place] = true;
            s.append("(").append(p.rang).append(",").append(p.place).append(") ");
        }
        System.out.println("Reservation annulée pour le groupe " + id + ". " +
                "Detail des places: " + s.toString());
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\n=== Plan de la salle ===\n");
        for (int i=0 ; i<nbRangs ; i++) {
            for (int j = 0; j < nbPlacesParRang; j++) {
                if (planSalle[i][j]) {
                    s.append(". ");
                }
                else {
                    s.append("X ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
