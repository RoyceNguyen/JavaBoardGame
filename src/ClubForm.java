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
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
		
		//Creating a GridPane container
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				
				//Create the firstName text field
				final TextField name = new TextField();
				Label fnameLabel = new Label("First Name:");
				GridPane.setConstraints(fnameLabel, 0, 0);
				grid.getChildren().add(fnameLabel);
				name.setPromptText("Enter your first name.");
				name.setPrefColumnCount(10);
				name.getText();
				GridPane.setConstraints(name, 1, 0);
				grid.getChildren().add(name);
				
				//Create the lastName text field
				final TextField lastName = new TextField();
				Label lnameLabel = new Label("Last Name:");
				GridPane.setConstraints(lnameLabel, 0, 1);
				grid.getChildren().add(lnameLabel);
				lastName.setPromptText("Enter your last name.");
				GridPane.setConstraints(lastName, 1, 1);
				grid.getChildren().add(lastName);
				
				//Create the email text field
				final TextField email = new TextField();
				Label emailLabel = new Label("Email:");
				GridPane.setConstraints(emailLabel, 0, 2);
				grid.getChildren().add(emailLabel);
				email.setPrefColumnCount(15);
				email.setPromptText("Enter your email.");
				GridPane.setConstraints(email, 1, 2);
				grid.getChildren().add(email);
				
				//Create the phone text field
				final TextField phone = new TextField();
				Label phoneLabel = new Label("Phone:");
				GridPane.setConstraints(phoneLabel, 0, 3);
				grid.getChildren().add(phoneLabel);
				phone.setPrefColumnCount(10);
				phone.setPromptText("Enter your phone number.");
				GridPane.setConstraints(phone, 1, 3);
				grid.getChildren().add(phone);
				
				//Create radio buttons for gender
				final ToggleGroup group = new ToggleGroup();
				Label gender = new Label("Select Gender");
				GridPane.setConstraints(gender, 2, 0);
				gender.setPadding(new Insets(0, 0, 0, 50));
				grid.getChildren().add(gender);
				RadioButton radio1 = new RadioButton("Male");
				RadioButton radio2 = new RadioButton("Female");
				radio1.setToggleGroup(group);
				radio2.setToggleGroup(group);
				
				radio1.setPadding(new Insets(0, 0, 0, 50));
				radio2.setPadding(new Insets(0, 0, 0, 50));
				grid.getChildren().addAll(radio1, radio2);
				GridPane.setConstraints(radio1, 2, 1);
				GridPane.setConstraints(radio2, 2, 2);
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
		intro.getChildren().addAll(grid,tellus,introduction,gameGenre,genre);
		

		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		submit.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt", true))) {
					bw.write("Member name : " + name.getText() + " " + lastName.getText() + ". Gender : " + group.getSelectedToggle() +" .To contact the member email them at " + email.getText() + " or call them at " + phone.getText() + ".");
					bw.newLine();
					bw.write("The member introduced themselve as follow : " + introduction.getText() + " . and their favorite board game genre is " + genre.getSelectionModel().getSelectedItem());
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
				name.clear();
				lastName.clear();
				email.clear();
				phone.clear();
				radio1.setSelected(false);
				radio2.setSelected(false);
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
		Scene scene = new Scene(border, 500, 530);
		stage.setTitle("Board Game Club");
		stage.setScene(scene);
		stage.show();
		}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}
	
}