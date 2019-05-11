package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import org.usehhapi.DataStructure.ChartData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ChartMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton Button;

    @FXML
    private BarChart<String, Number> BarChart;

    @FXML
    void initialize() {
    	BarChart.getData().clear();
    	ObservableList<ChartData> cd = FXCollections.observableArrayList();
    	//MainController.Vacancies;
    	ObservableList<String> cities = FXCollections.observableArrayList();
    	for(int i = 0 ; i < MainController.Vacancies.size();i++ ) {
    		
    		cities.add(MainController.Vacancies.get(i).getCity());
    	}
    	
    	for(int i = 0 ; i < cities.size();i++) {
    		
    		String c1 = cities.get(i);
    		int k = 0;
	    		for(int j = 0 ; j < cities.size();j++) {
	    		
	    			if(c1.equals(cities.get(j))) {
	    				k++;
	    				cities.remove(j);
	    			}
	    		}
	    		ChartData ct = new ChartData(c1,k);
	    		//System.out.println(c1+" "+ k);
	    		cd.add(ct);
	    		
    		}
    	ObservableList<ChartData> chartd = FXCollections.observableArrayList();
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
    		alt1.setName(chartd.get(i).getCity()+" "+chartd.get(i).getCount());
    		BarChart.getData().add(alt1);
    	}
    }
}
