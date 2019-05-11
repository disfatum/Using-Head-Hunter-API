package org.usehhapi.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.usehhapi.ConnectApi.Connect;
import org.usehhapi.DataStructure.Areas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane BorderPane;
    
    static public int WHAT = -1;
    static public Button fb = new Button();
    static public ObservableList<Areas> AreaList = FXCollections.observableArrayList();
    static public int c = -1;
    public void init() {
    	try {
			Parent Settings = FXMLLoader.load(getClass().getResource("/Settings.fxml"));
			BorderPane.setCenter(Settings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void initialize() {
    	AddAreas();
    	init();
    	
    	
        fb.setOnAction(e->{
        	if(c == 0) {
        		try {
        			Parent Settings = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        			WHAT= 1;
        			BorderPane.setCenter(Settings);
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        	}
			if(c == 1) {
				try {
					WHAT = 2;
        			Parent Settings = FXMLLoader.load(getClass().getResource("/Stat.fxml"));
        			BorderPane.setCenter(Settings);
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}     		
			}
			if(c == 2) {
				try {
        			Parent Settings = FXMLLoader.load(getClass().getResource("/Settings.fxml"));
        			BorderPane.setCenter(Settings);
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		} 
			}
			if(c == 3) {
				System.exit(0);
			}
        });
    }
    
    public void AddAreas() {
    	StringBuffer response;
		JSONArray jsonObject;
		Object objk ;	
		JSONObject Cname = new JSONObject();
		Connect http = new Connect();  
		JSONParser parser = new JSONParser();
	   	
		String url = "https://api.hh.ru/areas";	
		try {
			response = http.connectToApi(url);
		
			if(response.toString().length()>0)
			{
				objk  = parser.parse(response.toString());
				jsonObject = (JSONArray) objk;
				for(int index = 0; index < jsonObject.size();index++) {
					Cname =  (JSONObject) jsonObject.get(index);
					//JSONObject jsonSnipped = (JSONObject) Cname.get("name");
				//System.out.println( Cname.get("name"));	
				//System.out.println( Cname.get("id"));
				AreaList.add(new Areas(Cname.get("id"), Cname.get("name")));
				}
			}
	    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
