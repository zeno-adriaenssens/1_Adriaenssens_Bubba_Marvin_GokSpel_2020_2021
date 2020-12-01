package model.database;

import model.Speler;

import java.util.ArrayList;

public abstract class TekstLoadSaveTemplate {
    public abstract void saveSpelers(ArrayList<Speler> spelers);
    public abstract ArrayList<Speler> loadSpelers();
}
