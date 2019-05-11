package org.usehhapi.Views;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScene extends Application{
	static Stage primaryStage1;
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
		primaryStage.setTitle("");
		primaryStage.setScene(new Scene(root, 1000, 641));
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
		primaryStage1 = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static Stage getPrimaryStage() {
		return primaryStage1;
		
	}
}