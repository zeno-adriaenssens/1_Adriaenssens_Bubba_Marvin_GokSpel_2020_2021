package controller;

import model.Observer;
import model.Strategies.LoadSaveStrategies;
import view.AdminView;

public class AdminViewController implements Observer {
    private AdminView adminView;

    public AdminViewController(LoadSaveStrategies db) {
        adminView = new AdminView(db);
    }

    @Override
    public void update(String arg) {

    }
}
