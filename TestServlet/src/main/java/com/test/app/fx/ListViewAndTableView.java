package com.test.app.fx;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by zc on 15-6-7.
 */
public class ListViewAndTableView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bosses and Employees: Chapter 4 Working with Tables");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,500,250, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        root.setCenter(gridPane);

        Label candidateLbl = new Label("Boss");
        GridPane.setHalignment(candidateLbl, HPos.CENTER);
        gridPane.add(candidateLbl,0,0);

        ObservableList<Person> leaders = getPeople();
        final ListView<Person> leaderListView = new ListView<>(leaders);
        leaderListView.setPrefHeight(150);
        leaderListView.setPrefWidth(150);
        leaderListView.setMaxWidth(Double.MAX_VALUE);

        leaderListView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                Label leadLbl = new Label();
                Tooltip tooltip = new Tooltip();
                ListCell<Person> cell = new ListCell<Person>(){
                    @Override
                    protected void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        if(item != null){
                            leadLbl.setText(item.getAliasName());
                            setText(item.getFirstName() + " " + item.getLastName());
                            tooltip.setText(item.getAliasName());
                            setTooltip(tooltip);
                        }
                    }
                };
                return cell;
            }
        });

        gridPane.add(leaderListView,0,1);

        Label emplLbl = new Label("Employees");
        gridPane.add(emplLbl,2,0);
        GridPane.setHalignment(emplLbl,HPos.CENTER);

        final TableView<Person> employeeTableView = new TableView<>();
        employeeTableView.setPrefWidth(300);

        final ObservableList<Person> teamMembers = FXCollections.observableArrayList();
        employeeTableView.setItems(teamMembers);

        TableColumn<Person,String> aliasNameCol = new TableColumn<>("Alias");
        aliasNameCol.setEditable(true);
        aliasNameCol.setCellFactory(new PropertyValueFactory("lastName"));
        aliasNameCol.setPrefWidth(employeeTableView.getPrefWidth()/3);

        TableColumn<Person,String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameCol.setPrefWidth(employeeTableView.getPrefWidth()/3);

        TableColumn<Person,String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameCol.setPrefWidth(employeeTableView.getPrefWidth()/3);

        employeeTableView.getColumns().setAll(aliasNameCol,firstNameCol,lastNameCol);
        gridPane.add(employeeTableView,2,1);

        leaderListView.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends Person> observable, Person oldValue, Person newValue) -> {
                    if(observable != null && observable.getValue() != null){
                        teamMembers.clear();
                        teamMembers.addAll(observable.getValue().getEmployees());
                    }
                });

        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
        Person docX = new Person("Professor X","Charles","Xavier");
        docX.getEmployees().add(new Person("Wolverine","James", "Howlett"));
        docX.getEmployees().add(new Person("Wolverine1","James1", "Howlett1"));
        docX.getEmployees().add(new Person("Wolverine2","James2", "Howlett2"));

        Person magneto = new Person("Magneto","Max","Eisenhardt");
        Person biker = new Person("Mountain Biker","Jonathan","Gennick");

        people.addAll(docX,magneto,biker);
        return people;
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
