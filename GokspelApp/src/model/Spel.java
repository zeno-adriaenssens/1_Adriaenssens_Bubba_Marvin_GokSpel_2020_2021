package model;

import controller.AdminViewController;
import controller.GamblerViewController;
import model.Strategies.LoadSaveStrategies;
import model.database.LoadSaveFactory;

import java.util.ArrayList;

public class Spel implements Observable{
    private ArrayList<Observer> observers = new ArrayList<>();
    private LoadSaveStrategies db;
    private Speler speler;


    public Spel() {
        db = LoadSaveFactory.createStrategy("XLS");
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String string) {
        for (Observer observer: observers) {
            observer.update(string);
        }
    }

    private void setSpeler(String speler) {
        Speler s = db.find(speler);
        if (s == null) {
            throw new IllegalArgumentException("Speler niet gevonden");
        } else {
            this.speler = s;
            notifyObservers(speler);
        }
    }

    public Speler getSpeler() {
        return speler;
    }

    public void save() {
        db.saveSpelers(db.loadSpelers());
    }

    public LoadSaveStrategies getDb() {
        return this.db;
    }
}
