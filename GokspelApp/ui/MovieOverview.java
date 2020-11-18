package ui;

import domain.Movie;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.layout.*; 
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import domain.MovieCompany;

public class MovieOverview {	
	private MovieCompany movieCompany ;
    private TableView<Movie> table ;
    private ObservableList<Movie> movies;
           
	public MovieOverview (MovieCompany movieCompany){
		this.movieCompany = movieCompany;
		
		VBox root = new VBox();
		root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
       	Label lblHeading = new Label("Movie Inventory");        
        lblHeading.setFont(new Font("Arial", 20));
        table = new TableView<Movie>(); 
        refresh();
        TableColumn<Movie, String> colTitle = new TableColumn<Movie, String>("Movie Title");
        colTitle.setMinWidth(300);        
        colTitle.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
        TableColumn<Movie, Integer> colYear = new TableColumn<Movie, Integer>("Release Year");
        colYear.setMinWidth(100);
        colYear.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("year"));
        TableColumn<Movie, Double> colPrice = new TableColumn<Movie, Double>("Price");
        colPrice.setMinWidth(100);
        colPrice.setCellValueFactory(new PropertyValueFactory<Movie, Double>("price"));
        table.getColumns().addAll(colTitle, colYear, colPrice);
        //handler (lambda expression) voor dubbelklik met muis op een rij in tabel ->update prijs
        table.setRowFactory( tv -> {
            TableRow<Movie> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Movie movie = row.getItem();
                    String movieInfo= movie.getTitle()+" \nRecent price is "+ movie.getPrice()+" Euro: ";
        			new MovieDetailView(MovieOverview.this,movieInfo,movie);	
                }
            });
            return row;
        });
        Button addButton = new Button("Add dummy film");
		addButton.setOnAction(new AddDummyFilmHandler());
		Button priceUpdateButton = new Button("Update price of selected movie\n or doubleclick on movie row");
		priceUpdateButton.setOnAction(new UpdatePriceHandler());
		root.getChildren().addAll(lblHeading, table,addButton,priceUpdateButton); 
		
		Stage stage = new Stage();
		Scene scene = new Scene(root);		
		stage.setTitle("Movie Inventory"); 
        stage.setScene(scene); 
        stage.show();
     }
	
	public void displayErrorMessage(String errorMessage){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Information Alert");		 
		alert.setContentText(errorMessage);	 
		alert.show();
	}
	
	public void refresh(){
		movies = FXCollections.observableArrayList(movieCompany.getMovies());
		table.setItems(movies);
		table.refresh();
	}	
	    
    class AddDummyFilmHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			movieCompany.addDummyMovie();
			refresh();
			//zet rij cursor op toegevoegde lijn in tabel
			TableViewSelectionModel <Movie> tsm = table.getSelectionModel();
			tsm.select(movieCompany.getAantalMovies());
		}
	}
    
    class UpdatePriceHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			TableViewSelectionModel <Movie> tsm = table.getSelectionModel();
			Movie movie = tsm.getSelectedItem();
			String movieInfo= movie.getTitle()+" \nRecent price is "+ movie.getPrice()+" Euro: ";
			new MovieDetailView(MovieOverview.this,movieInfo,movie);
		}
	}    
}
