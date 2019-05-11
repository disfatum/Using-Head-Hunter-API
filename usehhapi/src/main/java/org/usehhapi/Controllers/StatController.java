package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import org.usehhapi.ConnectApi.Query2;
import org.usehhapi.DataStructure.ChartData;
import org.usehhapi.DataStructure.Vacancy;
import org.usehhapi.Views.Loading;
import org.usehhapi.Views.URLs;
import org.usehhapi.Views.Urls2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StatController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private BorderPane Bp;

    @FXML
    private URL location;

    @FXML
    private JFXButton Serach;

    @FXML
    private JFXButton MenuButton;

    @FXML
    private JFXTextField TextField;

    @FXML
    private JFXButton URL;

    @FXML
    private BarChart<String, Number> BarChart;

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
    boolean c = true;
    public static String TEXT;
    public static ObservableList<String> KeySkills = FXCollections.observableArrayList();
    public static ObservableList<ChartData> BarData = FXCollections.observableArrayList();
    public static ObservableList<Vacancy> Vacancies = FXCollections.observableArrayList();
    public static Button jb = new Button();
    @FXML
    void initialize() {
    	jb.setOnAction(e->{
    		for(int i = 0; i < LoadingController.BC.size();i++) {
    			BarChart.getData().add(LoadingController.BC.get(i));
    		}
    	});
    	
    	MenuButton.setOnAction(e->{
    		if(c == false) {
    			inf();
    			c = true;
    		}
    		else {
    			in();	
    			c = false;
    		}
    		
    	});
    	Serach.setOnAction(e->{
    		TEXT = TextField.getText();
    		 try {
 				Loading f = new Loading();
 				Stage primaryStage = new Stage();
 				f.start(primaryStage);
 			} catch (IOException e1) {
 				e1.printStackTrace();
 			}
    		
    	});
    	URL.setOnAction(e->{
   		 try {
				Urls2 f = new Urls2();
				Stage primaryStage = new Stage();
				f.start(primaryStage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	});
    }
    Service<Void> service = new Service<Void>() {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                	try {
         				Loading f = new Loading();
         				Stage primaryStage = new Stage();
         				f.start(primaryStage);
         			} catch (IOException e1) {
         				e1.printStackTrace();
         			}
                    return null;
                }
            };
        }
    };
	   
}
