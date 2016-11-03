import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClubForm extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		//Create border pane for the whole form
		BorderPane border = new BorderPane();
		
		//add title image and put it in an image view
		Image img = new Image("boardgame.png");
		ImageView imgVw = new ImageView();
		imgVw.setImage(img);
		//set the size of the title image view
		imgVw.setFitWidth(300);
		imgVw.setFitHeight(100);
		//create animation for image
		FadeTransition ft = new FadeTransition(Duration.millis(4000), imgVw);
		ft.setFromValue(0.1);
		ft.setToValue(1.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
		//create sound when app launches	    
	    //String voices = "voices.mp3";
	    Media sound = new Media(new File("voices.mp3").toURI().toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
		
		//create top hbox for the title image to sit in
		HBox top = new HBox();
		top.setPadding(new Insets(10,10,10,10));
		top.setSpacing(10);
		top.setStyle("-fx-background-color: #336699;");
		//add image view to the hbox
		top.getChildren().add(imgVw);
		top.setAlignment(Pos.CENTER);
		
		//create bottom hbox for the submit and clear buttons to sit in
		HBox bottom = new HBox();
		bottom.setPadding(new Insets(10,10,10,10));
		bottom.setSpacing(10);
		bottom.setStyle("-fx-background-color: #333333;");
		
		//create the submit and clear buttons

		//creating a label for text area
		Label tellus = new Label("Tell us about yourself:");
		//text area for user to introduce themselves
		TextArea introduction = new TextArea();
		introduction.setPrefHeight(100);
		//label for listview
		Label gameGenre = new Label("Board game genre youre interested in:");
		//list view that lists board game genres 
		ListView<String> genre = new ListView<String>();
		genre.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> genres = FXCollections.observableArrayList(
		"Strategy","Horror","Sci-fi","Trivia","Fantasy","Party","Math","Electronic","Children");
		genre.setPrefHeight(100);
		genre.setItems(genres);
		VBox intro = new VBox();
		intro.getChildren().addAll(tellus,introduction,gameGenre,genre);
		

		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		submit.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt", true))) {
			        bw.write(introduction.getText());
			        bw.newLine();
			        bw.write(genre.getSelectionModel().getSelectedItem());
			        bw.newLine();    
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			
		});

		Button clear = new Button("Clear");
		clear.setPrefSize(100, 20);
		//add buttons to the hbox
		clear.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				introduction.clear();
				genre.getSelectionModel().clearSelection();
			}
		}
		);

		bottom.getChildren().addAll(submit, clear);
		bottom.setAlignment(Pos.CENTER);
		
		//create grid pane for the central content of the app
		//GridPane grid = new GridPane();

		//grid.setStyle("-fx-background-color: #FFFF00;");
		//add the hboxes and grid pane to the border pane

		intro.setStyle("-fx-background-color: #FFFF00;");

		border.setTop(top);
		border.setCenter(intro);
		border.setBottom(bottom);
		//set the scene with the border pane
		Scene scene = new Scene(border, 500, 700);
		stage.setTitle("Board Game Club");
		stage.setScene(scene);
		stage.show();
		}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}
	
}
