package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import model.Spel;


public class GokSpelMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Spel spel = new Spel();
	}
}
