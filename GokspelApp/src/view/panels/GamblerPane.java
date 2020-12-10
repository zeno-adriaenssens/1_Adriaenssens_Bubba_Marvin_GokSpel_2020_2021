package view.panels;

import controller.GamblerViewController;
import javafx.scene.layout.GridPane;

public class GamblerPane extends GridPane {
    private GamblerViewController controller;

    public GamblerPane(GamblerViewController controller) {
        this.controller = controller;
    }
}
