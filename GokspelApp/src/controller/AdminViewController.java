package controller;

import model.Observer;
import model.Spel;
import model.Strategies.LoadSaveStrategies;
import view.AdminView;

public class AdminViewController implements Observer {
    private AdminView adminView;

    public AdminViewController(Spel spel) {
        adminView = new AdminView(spel);
    }

    @Override
    public void update(String arg) {

    }
}
