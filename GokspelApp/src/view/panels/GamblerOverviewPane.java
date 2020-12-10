package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Speler;
import model.Strategies.LoadSaveStrategies;


public class GamblerOverviewPane extends GridPane{
	private LoadSaveStrategies db;
	private ObservableList<Speler> spelers;

	
	public GamblerOverviewPane(LoadSaveStrategies db) {
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
		System.out.println("===========================================================================================================================");
		System.out.println("Load/Refresh of players");
		for (Speler s: spelers) {
			System.out.println(s.toString());
		}
	}
}