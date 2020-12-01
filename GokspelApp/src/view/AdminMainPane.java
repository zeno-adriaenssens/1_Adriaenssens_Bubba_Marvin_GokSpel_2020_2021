package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.SpelerTekstLoadSave;
import model.database.TekstLoadSaveTemplate;
import view.panels.GamblerOverviewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(TekstLoadSaveTemplate db){
	    TabPane tabPane = new TabPane(); 	    
        Tab spelVerloopTab = new Tab("Spelverloop");
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(db);
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Staitieken");
        tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
