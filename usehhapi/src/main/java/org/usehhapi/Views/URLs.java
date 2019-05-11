package org.usehhapi.Views;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class URLs extends Application {
	static Stage primaryStage1;
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Urls.fxml"));
		 
        // Specifies the owner Window (parent) for new window
		primaryStage.initOwner(MainScene.getPrimaryStage());
		primaryStage.setScene(new Scene(root, 600, 400));
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
