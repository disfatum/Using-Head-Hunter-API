package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class LeftMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton Main;

    @FXML
    private JFXButton Stat;

    @FXML
    private JFXButton Settings;

    @FXML
    private JFXButton Exit;

    @FXML
    void initialize() {
    	
        Main.setOnAction(e->{
        	MainSceneController.c = 0;
        	MainSceneController.fb.fire();
        });
        
        Stat.setOnAction(e->{
        	MainSceneController.c = 1;
        	MainSceneController.fb.fire();
        });
        
        Settings.setOnAction(e->{
        	MainSceneController.c = 2;
        	MainSceneController.fb.fire();
        });
        
        Exit.setOnAction(e->{
        	MainSceneController.c = 3;
        	MainSceneController.fb.fire();
        });

    }
}
