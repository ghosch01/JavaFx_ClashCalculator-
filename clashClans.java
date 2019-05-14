package Homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class clashClans extends Application {
	Scene scene1, scene2;
	Button btn1;
	Button btn2;
	Label results;
	TextField TextField1, TextField2, TextField3, TextField4;
	String inAnimal;
	Stage window;

	@Override

	public void start(Stage primaryStage) {

		BorderPane bp = new BorderPane();

		GridPane gp = createGridPane();
		bp.setCenter(gp);
		Label l = new Label("Clash of Clans Calculator");
		l.setId("bigLabel");
		bp.setTop(l);
		bp.setAlignment(l, Pos.CENTER);
		bp.setMargin(bp, new Insets(66, 12, 12, 12));

		Scene s = new Scene(bp, 300, 300);
		s.getStylesheets().add("myS.css");
		primaryStage.setTitle("Clash of Clans");
		primaryStage.setScene(s);
		primaryStage.show();

		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String msg = "Pending";
				if (TextField1.getText() != null && TextField2.getText() != null && TextField3.getText() != null
						&& TextField4.getText() != null) {
					String giant = TextField1.getText();
					String dragon = TextField2.getText();
					String wizard = TextField3.getText();
					String archer = TextField4.getText();
					try {

						int intGiant;
						int intDrag;
						int intWiz;
						int intArch;

						if (giant.isEmpty()) {
							intGiant = 0;
						} else
							intGiant = Integer.parseInt(giant) * 5;

						if (dragon.isEmpty()) {
							intDrag = 0;
						} else
							intDrag = Integer.parseInt(dragon) * 10;

						if (wizard.isEmpty()) {
							intWiz = 0;
						} else
							intWiz = Integer.parseInt(wizard) * 2;

						if (archer.isEmpty()) {
							intArch = 0;
						} else
							intArch = Integer.parseInt(archer) * 1;

						if (intGiant < 0 || intDrag < 0 || intWiz < 0 || intArch < 0) {
							msg = "Error, Positive Numbers Only!";
						} else
							msg = msg.format("Total Army Size: %s", (intGiant + intDrag + intWiz + intArch));
						System.out.printf(msg);
						results.setText(msg);
					} catch (Exception e) {
						msg = "Integers Only";
						results.setText(msg);
					}
				} else {
					msg = "Please enter a valid number!";
					results.setText(msg);
				}
			}
		});

	}

	private ImageView getImage(String fName) {
		ImageView iv = null;
		try {
			FileInputStream input = new FileInputStream(fName);
			Image image = new Image(input);
			iv = new ImageView(image);
			iv.setFitHeight(50);
			iv.setFitWidth(50);

		} catch (FileNotFoundException e) {
			System.out.printf("\nCannot open file: %s", e);
			e.printStackTrace();
			System.exit(1);
		}
		return iv;
	}

	private GridPane createGridPane() {
		Text Giants = new Text("Giants(5):");
		Giants.setId("smallText");
		Text Dragons = new Text("Dragons(10):");
		Dragons.setId("smallText");
		Text Wizards = new Text("Wizards(2):");
		Wizards.setId("smallText");
		Text Archers = new Text("Archer(1):");
		Archers.setId("smallText");
		TextField1 = new TextField();
		TextField2 = new TextField();
		TextField3 = new TextField();
		TextField4 = new TextField();

		btn1 = new Button("Submit");
		btn1.setId("font-button");

		results = new Label("");
		results.setId("resultText");

		GridPane gp = new GridPane();
		gp.add(Giants, 0, 0);
		gp.add(TextField1, 1, 0);
		gp.add(Dragons, 0, 1);
		gp.add(TextField2, 1, 1);
		gp.add(Wizards, 0, 2);
		gp.add(TextField3, 1, 2);
		gp.add(Archers, 0, 3);
		gp.add(TextField4, 1, 3);
		gp.add(btn1, 1, 5);
		gp.add(results, 1, 6);

		String fName = "res/Clans.PNG";
		ImageView iv = getImage(fName);
		gp.add(iv, 0, 5, 1, 2);

		gp.setVgap(5);
		gp.setHgap(5);
		gp.setAlignment(Pos.CENTER);

		return gp;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
