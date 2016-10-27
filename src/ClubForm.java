import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClubForm extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
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
		
		
		
		
		Scene scene = new Scene(grid);
		primaryStage.setTitle("BOARDGAME");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
	}

}
