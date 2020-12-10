package model.Strategies;

import model.Speler;
import model.Strategies.LoadSaveStrategies;

import java.util.ArrayList;

public abstract class TekstLoadSaveTemplate implements LoadSaveStrategies {
    public abstract void saveSpelers(ArrayList<Speler> spelers);
    public abstract ArrayList<Speler> loadSpelers();
}
