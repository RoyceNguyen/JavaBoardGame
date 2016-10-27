import javafx.application.Application;
import javafx.geometry.Insets;
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
		
		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		Button clear = new Button("Clear");
		clear.setPrefSize(100, 20);
		bottom.getChildren().addAll(submit, clear);
		
		VBox left = new VBox();
		left.setPadding(new Insets(10,250,10,10));
		left.setSpacing(10);
		left.setStyle("-fx-background-color: #FF0000;");
		VBox right = new VBox();
		right.setPadding(new Insets(10,10,10,250));
		right.setSpacing(10);
		right.setStyle("-fx-background-color: #00FFFF;");
		//GridPane grid = new GridPane();
		//grid.setStyle("-fx-background-color: #FFFF00;");
		border.setTop(top);
		border.setLeft(left);
		//border.setCenter(grid);
		border.setRight(right);
		border.setBottom(bottom);
		Scene scene = new Scene(border, 500, 700);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
