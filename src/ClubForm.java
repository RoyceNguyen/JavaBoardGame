import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClubForm extends Application {

	@Override
	public void start(Stage stage) throws Exception{
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
		
		//pane to hold the application 
				BorderPane border = new BorderPane();
				HBox top = new HBox();
				top.setPadding(new Insets(60,60,60,60));
				top.setSpacing(10);
				top.setStyle("-fx-background-color: #336699;");
				HBox bottom = new HBox();
				bottom.setPadding(new Insets(10,10,10,10));
				bottom.setSpacing(10);
				bottom.setStyle("-fx-background-color: #333333;");
				
				//creating a label for texta area
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
				
				//GridPane grid = new GridPane();
				intro.setStyle("-fx-background-color: #FFFF00;");
				border.setTop(top);
				//border.setCenter(grid);
				border.setCenter(intro);
				border.setBottom(bottom);
				
				Scene scene = new Scene(border, 500, 700);
				stage.setScene(scene);
				stage.show();
			

				}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Application.launch(args);
		}
			
		}