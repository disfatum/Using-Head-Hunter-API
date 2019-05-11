package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.sun.glass.events.MouseEvent;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import org.usehhapi.ConnectApi.Query;
import org.usehhapi.ConnectApi.Query2;
import org.usehhapi.DataStructure.ChartData;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LoadingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXSpinner spinner;

    @FXML
    private JFXButton Button;
    static public ObservableList<XYChart.Series<String, Number>> BC = FXCollections.observableArrayList();
    static public JFXButton b1 = new JFXButton();;
    boolean f = false;
    int c = 0;
    public static Stage ps; 
    @FXML
    void initialize() {
    	Button.setOnAction(e->{
    		Platform.runLater(() -> c = 1);
			Stage ps;
	    	ps  = (Stage) spinner.getScene().getWindow();
	    	ps.close();
	    	StatController.jb.fire();
    	});
    	b1.setOnAction(e->{
    			Stage ps;
    	    	ps  = (Stage) spinner.getScene().getWindow();
    	    	ps.close();
    	});
    	service.start();
    	
    	//service.start();
    }
    Service<Void> service = new Service<Void>() {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
         
           if (c == 0) { 
        	   if (MainSceneController.WHAT == 2) {
	    	ObservableList<XYChart.Series<String, Number>> BCbuf = FXCollections.observableArrayList();
	    	//KeySkills.clear();
    		Query2 Query = new Query2();
    		String text;
			//Platform.runLater(() -> text = StatController.TEXT);
    		System.out.println( StatController.TEXT);
    		ObservableList<ChartData> chartd = FXCollections.observableArrayList();
    		try {
				Query.Search(StatController.TEXT, SettingsController.Area,
						StatController.KeySkills,StatController. Vacancies,SettingsController.vacCounter);
				
				//BarChart.getData().clear();
		    	ObservableList<ChartData> cd = FXCollections.observableArrayList();
		    	//MainController.Vacancies;
		    	
		    	for(int i = 0 ; i <StatController. KeySkills.size();i++) {
		    		
		    		String c1 = StatController.KeySkills.get(i);
		    		int k = 0;
			    		for(int j = 0 ; j < StatController.KeySkills.size();j++) {
			    		
			    			if(c1.equals(StatController.KeySkills.get(j))) {
			    				k++;
			    				StatController.KeySkills.remove(j);
			    			}
			    		}
			    		ChartData ct = new ChartData(c1,k);
			    		//System.out.println(c1+" "+ k);
			    		cd.add(ct);
			    		
		    		}
		    	
		    	for(int i = 0; i < cd.size();i++) {
		    		ChartData ct2 = cd.get(i);
		    		for(int j = 0;j < cd.size();j++) {
		    			if(ct2.getCity().toLowerCase().contains(cd.get(j).getCity().toLowerCase())) {
		    				ct2.setCount(ct2.getCount()+cd.get(j).getCount());
		    				cd.remove(j);
		    			}
		    			
		    		}chartd.add(ct2);
		    	}
		    	
		    	for(int i = 0; i < chartd.size(); i++) {
		    		XYChart.Series<String, Number> alt1 = new XYChart.Series<String, Number>();
		    		alt1.getData().add(new XYChart.Data<String, Number>("", chartd.get(i).getCount()));
		    		alt1.setName(chartd.get(i).getCity()+ " "+chartd.get(i).getCount());
		    		BCbuf.add(alt1);
		    		//BarChart.getData().add(alt1);
		    	}
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		System.out.println(StatController.KeySkills.size());
    		
    		Platform.runLater(() -> BC = BCbuf);
    		System.out.println(StatController.KeySkills.size());
    		Platform.runLater(() -> Button.fire());
           }
        	   if(MainSceneController.WHAT == 1) {
        		   Query Query = new Query();
        		   Query.Search(MainController.text, SettingsController.Area,
        				   MainController.TableData, MainController.Vacancies,SettingsController.vacCounter );
        		   Platform.runLater(() -> Button.fire());
        	   }
           }
		return null;   
	    }
            };
        }
	};
}
