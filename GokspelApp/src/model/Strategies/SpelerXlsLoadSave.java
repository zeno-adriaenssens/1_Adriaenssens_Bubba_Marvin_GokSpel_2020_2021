package model.Strategies;

import excel.ExcelPlugin;
import model.Speler;

import java.io.File;
import java.util.ArrayList;

public class SpelerXlsLoadSave{
    public void saveSpelers(ArrayList<Speler> spelers) {
        try{
            File file = new File("C:\\Users\\Zeno\\Desktop\\school\\UCLL\\2020-2021\\OOO\\Groepswerk\\1_Adriaenssens_Bubba_Marvin_GokSpel_2020_2021\\GokspelApp\\src\\bestanden\\speler.xls");
            ArrayList<ArrayList<String>> args = new ArrayList<>();
            for (Speler s: spelers) {
                /*ArrayList<String> speler = [s.getFamilienaam(),s.getVoornaam(),s.getSpelernaam(),String.valueOf(s.getGoksaldo());];*/
                ArrayList<String> speler = new ArrayList<String>();
                speler.add(s.getFamilienaam());
                speler.add(s.getVoornaam());
                speler.add(s.getSpelernaam());
                speler.add(String.valueOf(s.getGoksaldo()));
                args.add(speler);
            }
            new ExcelPlugin().write(file, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Speler> loadSpelers() {
        try {
            ArrayList<ArrayList<String>> args = new ExcelPlugin().read(new File("C:\\Users\\Zeno\\Desktop\\school\\UCLL\\2020-2021\\OOO\\Groepswerk\\1_Adriaenssens_Bubba_Marvin_GokSpel_2020_2021\\GokspelApp\\src\\bestanden\\speler.xls"));
            ArrayList<Speler> spelers = new ArrayList<>();
            for (ArrayList<String> s: args) {
                spelers.add(new Speler(s.get(0), s.get(1), s.get(2), Double.parseDouble(s.get(3))));
            }
            return spelers;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Speler find(String naam) {
        ArrayList<Speler> spelers = loadSpelers();
        for (Speler speler:spelers) {
            if (speler.getSpelernaam().equals(naam)){
                return speler;
            }
        }
        throw new IllegalArgumentException("speler not found");
    }
}
