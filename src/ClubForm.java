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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClubForm extends Application{

	@Override
	public void start(Stage stage) throws Exception {
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
		intro.getChildren().addAll(tellus,introduction,gameGenre,genre);
		
		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		Button clear = new Button("Clear");
		clear.setPrefSize(100, 20);
		bottom.getChildren().addAll(submit, clear);
		bottom.setAlignment(Pos.CENTER);
		
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #FFFF00;");
		border.setTop(top);
		border.setCenter(grid);
		border.setBottom(bottom);
		
		Scene scene = new Scene(border, 500, 700);
		stage.setScene(scene);
		stage.show();
	
		// TODO Auto-generated method stub
		
		//Scene scene = new Scene(intro);
		//primaryStage.setScene(scene);
		//primaryStage.show();
		}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}
	
}
