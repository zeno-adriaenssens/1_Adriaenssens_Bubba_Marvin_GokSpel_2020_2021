package ui;

import domain.Movie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MovieDetailView extends GridPane {
	private Stage stage = new Stage();
	MovieOverview movieOverview;
	private Button btnOK, btnCancel;
	private TextField priceField;	

	public MovieDetailView(MovieOverview m, String movieInfo, Movie movie) {
		this.movieOverview = m;
		stage.setTitle("Update price");
		stage.initModality(Modality.APPLICATION_MODAL);
		this.setPrefHeight(150);
		this.setPrefWidth(500);
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Update price for: "+movieInfo), 0, 0, 1, 1);
		priceField = new TextField();
		this.add(priceField, 1, 0, 1, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	            stage.close();
	        }	        
		});
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	        	try{
	        		movie.setPrice(Double.parseDouble(priceField.getText()));
	        	}
	        	catch (NumberFormatException ex){
	        		movieOverview.displayErrorMessage("prijs mag niet leeg zijn en moet een getal zijn");
	        	}
	        	catch (IllegalArgumentException ex){
	        		movieOverview.displayErrorMessage(ex.getMessage());
	        	}	        	
	            movieOverview.refresh();
	            stage.close();
	        }	        
		});		
		btnOK.isDefaultButton();
		this.add(btnOK, 1, 3, 1, 1);
		
		Scene scene = new Scene(this);
		stage.setScene(scene);
		stage.show();     
	}
}
