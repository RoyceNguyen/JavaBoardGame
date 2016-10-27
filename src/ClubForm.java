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
		BorderPane border = new BorderPane();
		
		Image img = new Image("boardgame.png");
		ImageView imgVw = new ImageView();
		imgVw.setImage(img);
		imgVw.setFitWidth(300);
		imgVw.setFitHeight(100);
		
		HBox top = new HBox();
		top.setPadding(new Insets(10,10,10,10));
		top.setSpacing(10);
		top.setStyle("-fx-background-color: #336699;");
		top.getChildren().add(imgVw);
		top.setAlignment(Pos.CENTER);
		
		HBox bottom = new HBox();
		bottom.setPadding(new Insets(10,10,10,10));
		bottom.setSpacing(10);
		bottom.setStyle("-fx-background-color: #333333;");
		
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
		stage.setTitle("Board Game Club");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
