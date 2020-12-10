package model;

import controller.AdminViewController;
import controller.GamblerViewController;
import model.Strategies.LoadSaveStrategies;
import model.database.LoadSaveFactory;

import java.util.ArrayList;

public class Spel implements Observable{
    ArrayList<Observer> observers = new ArrayList<>();

    public Spel() {
        LoadSaveStrategies db = LoadSaveFactory.createStrategy("XLS");
        AdminViewController adminView = new AdminViewController(db);
        GamblerViewController gamblerView = new GamblerViewController();
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
}
