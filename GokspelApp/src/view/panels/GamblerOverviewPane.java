package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Speler;
import model.database.SpelerTekstLoadSave;
import model.database.TekstLoadSaveTemplate;
import view.AdminMainPane;

import javax.swing.*;


public class GamblerOverviewPane extends GridPane{
	private TekstLoadSaveTemplate db;
	private ObservableList<Speler> spelers;

	
	public GamblerOverviewPane(TekstLoadSaveTemplate db) {
		this.db = db;
		refresh();

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);        
		this.add(new Label("Spelers:"), 0, 0, 1, 1);

		for (int x = 0; x < spelers.size(); x++) {
			this.add(new Label(spelers.get(x).getFamilienaam()), 0, 1 + x, 1, 1);
			this.add(new Label(spelers.get(x).getVoornaam()), 1, 1 + x, 1, 1);
			this.add(new Label(spelers.get(x).getSpelernaam()), 2, 1 + x, 1, 1);
			this.add(new Label(String.valueOf(spelers.get(x).getGoksaldo())), 3, 1 + x, 1, 1);
		}
	}

	public void refresh(){
		spelers = FXCollections.observableArrayList(db.loadSpelers());
	}
}