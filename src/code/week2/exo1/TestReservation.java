package code.week2.exo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by an.auger on 06/05/2017.
 */
public class TestReservation {
    public TestReservation(Salle salle, Random rand) {
        List<Groupe> groupes = new ArrayList<>();
        groupes.add(new Groupe(1, 5, salle, rand, true));
        groupes.add(new Groupe(2, 2, salle, rand, false));
        groupes.add(new Groupe(3, 12, salle, rand, false));
        groupes.add(new Groupe(4, 15, salle, rand, true));
        groupes.add(new Groupe(5, 2, salle, rand, false));

        List<Thread> allThreads = new ArrayList<>();
        for (Groupe g : groupes) {
            allThreads.add(new Thread(g));
        }

        System.out.println(salle);

        for (Thread t : allThreads) {
            t.start();
        }

        try {
            for (Thread t : allThreads) {
                t.join();
            }

            Thread tLast = new Thread(new Groupe(6, 3, salle, rand, false));
            tLast.start();
            tLast.join();

            System.out.println(salle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
