import javafx.application.Application;
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
		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		Button clear = new Button("Clear");
		clear.setPrefSize(100, 20);
		//add buttons to the hbox
		bottom.getChildren().addAll(submit, clear);
		bottom.setAlignment(Pos.CENTER);
		
		//create grid pane for the central content of the app
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #FFFF00;");
		//add the hboxes and grid pane to the border pane
		border.setTop(top);
		border.setCenter(grid);
		border.setBottom(bottom);
		//set the scene with the border pane
		Scene scene = new Scene(border, 500, 700);
		stage.setTitle("Board Game Club");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
