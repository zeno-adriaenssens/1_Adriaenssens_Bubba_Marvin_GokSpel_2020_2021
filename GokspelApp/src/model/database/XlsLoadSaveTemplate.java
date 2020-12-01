package model.database;


import model.Speler;
import model.Strategies.LoadSafeStrategies;

import java.util.ArrayList;

public abstract class XlsLoadSaveTemplate implements LoadSafeStrategies {
    public abstract void saveSpelers(ArrayList<Speler> spelers);
    public abstract ArrayList<Speler> loadSpelers();
}
