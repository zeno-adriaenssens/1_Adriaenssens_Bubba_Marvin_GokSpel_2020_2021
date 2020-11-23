package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.SpelerTekstLoadSave;
import view.AdminView;
import view.GamblerView;

public class GokSpelMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		SpelerTekstLoadSave db = new SpelerTekstLoadSave();
		AdminView adminView = new AdminView(db);
		GamblerView gamblerView = new GamblerView();
	}
}
