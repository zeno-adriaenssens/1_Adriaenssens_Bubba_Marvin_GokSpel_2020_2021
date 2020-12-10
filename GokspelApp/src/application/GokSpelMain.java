package application;
	

import controller.GamblerViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Spel;
import view.AdminView;
import view.GamblerView;


public class GokSpelMain extends Application {
	private Spel spel;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.spel = new Spel();
		new AdminView(spel);
		GamblerViewController controller = new GamblerViewController(spel);
		new GamblerView(controller);
	}
}
