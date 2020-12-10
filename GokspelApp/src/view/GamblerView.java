package view;

import controller.GamblerViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Spel;
import view.panels.GamblerPane;

public class GamblerView {
	private Stage stage = new Stage();		
		
	public GamblerView(GamblerViewController controller){
		stage.setTitle("GAMBLER VIEW");

		//Code beneath makes that the program is  unvisible on your windows taskbar
		//stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		GridPane gamblerPane = new GamblerPane(controller);

		root.getChildren().add(gamblerPane);
		Scene scene = new Scene(root, 600, 600);
		gamblerPane.prefWidthProperty().bind(scene.widthProperty());
		gamblerPane.prefHeightProperty().bind(scene.heightProperty());
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		/*Group root = new Group();
		Scene scene = new Scene(root, 600, 600);*/
	}
}
