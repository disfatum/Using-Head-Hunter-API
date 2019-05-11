package org.usehhapi.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.usehhapi.DataStructure.Areas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView MenuButton;

    @FXML
    private BorderPane Bp;
    
    @FXML
    private JFXButton Button;
    
    @FXML
    private JFXComboBox<String> AreaBox;

    @FXML
    private JFXTextField TextField;

    @FXML
    private JFXComboBox<String> ExpBox;
    public static int vacCounter = 0;
    Parent LeftMenu; 
    public void in() {
    	
			try {
				 LeftMenu = FXMLLoader.load(getClass().getResource("/LeftMenu.fxml"));
				Bp.setLeft(LeftMenu);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }
    public void inf() {
    	
		try {
			Parent Null = FXMLLoader.load(getClass().getResource("/Null.fxml"));
		     Bp.setLeft(Null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
    static public Areas Area = new Areas("", "");;
    boolean c = true;
    @FXML
    void initialize() {
    	TextField.setText("100");
    	addArea();
    	Button.setOnAction(e->{
    		Area = MainSceneController.AreaList.get(L.indexOf(AreaBox.getValue()));
    		vacCounter = Integer.valueOf(TextField.getText());
    		if(c == false) {
    			inf();
    			c = true;
    		}
    		else {
    			in();	
    			c = false;
    		}
    		
    	});
    }
    ObservableList<String> L = FXCollections.observableArrayList();
    void addArea() {
    	L.clear();
    	for(int i = 0; i < MainSceneController.AreaList.size(); i++) {
    		L.add(MainSceneController.AreaList.get(i).getName());
    	}
    	System.out.println(L);
    	AreaBox.setItems(L);
    	AreaBox.setValue(L.get(0));
    }
}
