package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.SpelerTekstLoadSave;
import model.database.SpelerXlsLoadSave;
import model.database.TekstLoadSaveTemplate;
import view.AdminView;
import view.GamblerView;

public class GokSpelMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		TekstLoadSaveTemplate db = new SpelerXlsLoadSave();
		AdminView adminView = new AdminView(db);
		GamblerView gamblerView = new GamblerView();
	}
}
