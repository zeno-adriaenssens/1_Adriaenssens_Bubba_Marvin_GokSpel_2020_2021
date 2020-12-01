package view;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.database.SpelerTekstLoadSave;
import model.database.TekstLoadSaveTemplate;

public class AdminView {
	private Stage stage = new Stage();
	private TekstLoadSaveTemplate db;

	public AdminView(TekstLoadSaveTemplate db){
		this.db = db;
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(630);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		BorderPane borderPane = new AdminMainPane(db);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
