package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import org.usehhapi.ConnectApi.Query;
import org.usehhapi.DataStructure.Vacancy;
import org.usehhapi.Views.ChartMain;
import org.usehhapi.Views.Loading;
import org.usehhapi.Views.URLs;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton Search;
    
    @FXML
    private TableView<String> Table;

    @FXML
    private JFXTextField TextField;
    
    @FXML
    private JFXButton MenuButton;
    
    @FXML
    private BorderPane Bp;
    
    @FXML
    private JFXPopup pop;
    
    @FXML
    private JFXPopup selpop;
    
    @FXML
    private JFXButton URL;

    @FXML
    private JFXButton Graph;

    
    Parent LeftMenu; 
    public static ObservableList<Vacancy> Vacancies = FXCollections.observableArrayList();
    public static ObservableList <String> TableData = FXCollections.observableArrayList();
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
    @FXML
    void initialize() {
    	pop = new JFXPopup();
    	selpop = new JFXPopup();
    	addCol();
    	Table.setItems(TableData);
    	popups();
    	spop();
    	Ev();
    	
    	
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
    	
    	Search.setOnAction(e->{
    		text = TextField.getText();	
    		try {
				Loading f = new Loading();
				Stage primaryStage = new Stage();
				f.start(primaryStage);
				text = TextField.getText();
				
				//Query.Search(MainController.text, SettingsController.Area,TableData, Vacancies,SettingsController.vacCounter );
			} catch (IOException e1) {
				//e1.printStackTrace();
			}
    	});
    	URL.setOnAction(e->{
    		 try {
				URLs f = new URLs();
				Stage primaryStage = new Stage();
				f.start(primaryStage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	});
    	Graph.setOnAction(e->{
    		try {
				ChartMain f = new ChartMain();
				Stage primaryStage = new Stage();
				f.start(primaryStage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	});
    	 		
    }
    public static Query Query = new Query();	
    public static String text = new String(); 
    public void popups() {
    	Label l  = new Label("Введите название навыка");
    	JFXButton b1 = new JFXButton("Добвить");
    	JFXTextField tf = new JFXTextField();
    	
    	b1.alignmentProperty().set(Pos.CENTER);
    	l.setPrefSize(350, 50);
    	b1.setPrefSize(350, 50);
    	tf.setPrefSize(350, 50);
    	l.setAlignment(Pos.CENTER);
    	tf.setAlignment(Pos.CENTER);
    	b1.setOnMouseClicked(e->{
    		TableData.add(tf.getText());
    	});
    	VBox vb = new VBox(l,tf,b1);
    	vb.alignmentProperty().set(Pos.CENTER);
    	pop.setPopupContent(vb);
    }
    
    public void spop() {
    	JFXButton b1 = new JFXButton("Добвить");
    	JFXButton b2 = new JFXButton("Удалить");
    	
    	b1.alignmentProperty().set(Pos.CENTER);
    	b2.setPrefSize(350, 50);
    	b1.setPrefSize(350, 50);
    	b2.setAlignment(Pos.CENTER);
    	
    	b1.setOnMouseClicked(e->{
    		showPop(e, pop);
    	});
    	b2.setOnMouseClicked(e->{
    		TableData.remove( Table.getSelectionModel().getSelectedIndex());
    		Table.refresh();
    	});
    	VBox vb = new VBox(b1,b2);
    	vb.alignmentProperty().set(Pos.CENTER);
    	selpop.setPopupContent(vb);
    }
    int selectedcol = 0;
    
    public void Ev() {
    	Table.setOnMouseClicked(e->{
	    	 if(e.getClickCount() == 1 && e.getButton().equals(MouseButton.SECONDARY)
	        			&& Table.getSelectionModel().getSelectedCells().isEmpty() == false) {
	    		 selectedcol = Table.getSelectionModel().getSelectedIndex();
	        		showPop(e, selpop);
	        	}
	         if(e.getClickCount() == 1 && e.getButton().equals(MouseButton.SECONDARY)
	        			&& Table.getSelectionModel().getSelectedCells().isEmpty() == true) {
	        		showPop(e, pop);
	        	}
	     });
    }
    public void addCol() {
    	//Col.sortableProperty().set(false);
    	TableColumn<String,String> firstNameCol = new TableColumn<String,String>("Таблица ключевых навыков");
    	Table.getColumns().add(firstNameCol);
    	firstNameCol.sortableProperty().set(false);
    	firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<String, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<String, String> p) {
		    	 
		    	 return new ReadOnlyObjectWrapper<String>(p.getValue());
		    	 
		     }
		  });
    	
    }
    public void showPop (MouseEvent e , JFXPopup Fnamepop) {
		
    	Node node = (Node) e.getSource();
    	Fnamepop.show(node, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, e.getX(), e.getY());
    	
    }
}
