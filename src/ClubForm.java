import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClubForm extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
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
		intro.getChildren().addAll(tellus,introduction,gameGenre,genre);
		Scene scene = new Scene(intro);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
