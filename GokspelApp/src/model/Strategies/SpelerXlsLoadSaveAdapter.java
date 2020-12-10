package model.Strategies;

import model.Speler;

import java.util.ArrayList;

public class SpelerXlsLoadSaveAdapter implements LoadSaveStrategies{
    private SpelerXlsLoadSave loadSave = new SpelerXlsLoadSave();

    public SpelerXlsLoadSaveAdapter() {

    }

    @Override
    public void saveSpelers(ArrayList<Speler> spelers) {
        loadSave.saveSpelers(spelers);
    }

    @Override
    public ArrayList<Speler> loadSpelers() {
        return loadSave.loadSpelers();
    }
}
