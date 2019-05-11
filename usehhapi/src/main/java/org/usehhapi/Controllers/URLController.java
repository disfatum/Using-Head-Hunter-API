package org.usehhapi.Controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import org.usehhapi.DataStructure.Vacancy;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class URLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Vacancy> TableView;

    @FXML
    private JFXButton Button;

    @FXML
    void initialize() {
        //MainController.Vacancies;
        TableColumn<Vacancy, String> c1 = new TableColumn<Vacancy, String> ("Ссылка на вакансию");
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
     // On Cell edit commit (for FullName column)
    	c1.setOnEditCommit((CellEditEvent<Vacancy, String> event4) -> {
    		TablePosition<Vacancy, String> pos = event4.getTablePosition();
        });
        c1.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableColumn<Vacancy, String> c2 = new TableColumn<Vacancy, String> ("Названия вакансии");
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableColumn<Vacancy, String> c6 = new TableColumn<Vacancy, String> ("адрес");
        c6.setCellValueFactory(new PropertyValueFactory<>("city"));
        c6.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableColumn<Vacancy, String> c3 = new TableColumn<Vacancy, String> ("api URL");
        c3.setCellValueFactory(new PropertyValueFactory<>("URL"));
        c3.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableColumn<Vacancy, Integer> c4 = new TableColumn<Vacancy, Integer> ("Количество навыков");
        c4.setCellValueFactory(new PropertyValueFactory<>("Allkeys"));
       // c4.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableColumn<Vacancy, Integer> c5 = new TableColumn<Vacancy, Integer> ("Найденные навыки");
        c5.setCellValueFactory(new PropertyValueFactory<>("findkeys"));
        //c5.setCellFactory(TextFieldTableCell.<Vacancy> forTableColumn());
        TableView.getColumns().add(c1);
        TableView.getColumns().add(c2);
        TableView.getColumns().add(c6);
        TableView.getColumns().add(c3);
        TableView.getColumns().add(c4);
        TableView.getColumns().add(c5);
        
        TableView.setItems(MainController.Vacancies);
    }
}