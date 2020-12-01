package model.database;

import model.Speler;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SpelerTekstLoadSave extends TekstLoadSaveTemplate {

    @Override
    public void saveSpelers(ArrayList<Speler> spelers) {
        try {
            PrintWriter printWriter = new PrintWriter(new File("src\\bestanden\\speler.txt"));
            for (Speler product : spelers) {
                printWriter.write(product.toString() + "\n");
            }
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Speler> loadSpelers() {
        try {
            ArrayList<Speler> spelers = new ArrayList<>();
            Scanner scanner = new Scanner(new File("src\\bestanden\\speler.txt"));
            scanner.useDelimiter("[,\n]");
            while (scanner.hasNextLine()) {
                String familienaam = scanner.next();
                String voornaam = scanner.next();
                String spelernaam = scanner.next();
                String goksaldo = scanner.next();


                Speler speler = new Speler(familienaam, voornaam, spelernaam, Double.valueOf(goksaldo));
                System.out.println(speler.toString());

                spelers.add(speler);
            }

            scanner.close();
            return spelers;
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

