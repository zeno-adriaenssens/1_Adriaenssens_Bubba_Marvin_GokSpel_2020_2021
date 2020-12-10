package model.Strategies;

import model.Speler;

import java.util.ArrayList;

public interface LoadSaveStrategies {
    public abstract void saveSpelers(ArrayList<Speler> spelers);
    public abstract ArrayList<Speler> loadSpelers();
}
