package controller;

import model.Observer;
import view.GamblerView;

public class GamblerViewController implements Observer {
    GamblerView gamblerView;

    public GamblerViewController() {
        this.gamblerView = new GamblerView();
    }

    @Override
    public void update(String arg) {

    }
}
