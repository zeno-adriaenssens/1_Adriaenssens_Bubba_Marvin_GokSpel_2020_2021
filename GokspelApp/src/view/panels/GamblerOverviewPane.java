package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Speler;
import model.Strategies.LoadSaveStrategies;


public class GamblerOverviewPane extends GridPane{
	private TableView<Speler> table;
	private LoadSaveStrategies db;
	private ObservableList<Speler> spelers;

	
	public GamblerOverviewPane(LoadSaveStrategies db) {
		this.db = db;
		//refresh();

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);        
		this.add(new Label("Spelers:"), 0, 0, 1, 1);

		/*Create table*/
		this.table = new TableView<Speler>();
		this.table.setManaged(true);
		this.table.setMinSize(600,600);

		/*Loading items from file*/
		refresh();

		/*Label on top*/
		Label lblHeading = new Label("Speler Overview");
		lblHeading.setFont(new Font("Arial", 20));

		/*Column with spelers id*/
		TableColumn<Speler, Double> colId = new TableColumn<Speler, Double>("Uniek spelernaam");
		/*colId.setMinWidth(100);*/
		colId.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/4
		colId.setCellValueFactory(new PropertyValueFactory<Speler, Double>("spelernaam"));

		/*Column with last name*/
		TableColumn<Speler, String> colLastName = new TableColumn<Speler, String>("Achternaam");
		/*colLastName.setMinWidth(100);*/
		colLastName.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/4
		colLastName.setCellValueFactory(new PropertyValueFactory<Speler, String>("familienaam"));

		/*Column with first name*/
		TableColumn<Speler, Integer> colFirstName = new TableColumn<Speler, Integer>("Voornaam");
		/*colFirstName.setMinWidth(100);*/
		colFirstName.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/4
		colFirstName.setCellValueFactory(new PropertyValueFactory<Speler, Integer>("voornaam"));

		/*Column with balance*/
		TableColumn<Speler, Double> colBalance = new TableColumn<Speler, Double>("Saldo");
		/*		colBalance.setMinWidth(100);*/
		colBalance.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/4
		colBalance.setCellValueFactory(new PropertyValueFactory<Speler, Double>("goksaldo"));

		/*Adds the coloms inside table*/
		table.getColumns().addAll(colId,colLastName, colFirstName,colBalance);

		/*		Adds table inside this scene*/
		this.getChildren().addAll(lblHeading,table);
	}

	public void refresh(){
		spelers = FXCollections.observableArrayList(db.loadSpelers());
		this.table.setItems(spelers);
		this.table.refresh();
	}
}