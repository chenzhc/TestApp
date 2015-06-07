package com.test.app.fx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-7.
 */
public class ListViewsTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hero Picker: Chapter 4 Creating and Working with ListViews");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,400,250, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(50);
        ColumnConstraints column3 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column3.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1,column2,column3);


        Label candidatesLbl = new Label("Candidates");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridPane.add(candidatesLbl,0,0);

        Label heroesLbl = new Label("Heroes");
        gridPane.add(heroesLbl,2,0);
        GridPane.setHalignment(heroesLbl,HPos.CENTER);

        final ObservableList<String> candidates = FXCollections.observableArrayList("Supermain",
                "Spiderman",
                "Wolverine",
                "Police",
                "Fire Rescue",
                "Soldiers",
                "Dad & Mom",
                "Doctor",
                "Politician",
                "Pastor",
                "Teacher");
        final ListView<String> candidatesListView = new ListView<>(candidates);
        gridPane.add(candidatesListView,0,1);

        final ObservableList<String> heroes = FXCollections.observableArrayList();
        final ListView<String> heroListView = new ListView<>(heroes);

        gridPane.add(heroListView,2,1);

        Button sendRightButton = new Button(" > ");
        sendRightButton.setOnAction((ActionEvent event) -> {
            String potential = candidatesListView.getSelectionModel().getSelectedItem();
            if(potential != null){
                candidatesListView.getSelectionModel().clearSelection();
                candidates.remove(potential);
                heroes.add(potential);
            }
        });

        Button sendLeftButton = new Button(" < ");
        sendLeftButton.setOnAction((ActionEvent event) -> {
            String notHero = heroListView.getSelectionModel().getSelectedItem();
            if(notHero != null){
                heroListView.getSelectionModel().clearSelection();
                heroes.remove(notHero);
                candidates.add(notHero);
            }
        });

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(sendRightButton,sendLeftButton);

        gridPane.add(vbox,1,1);
        root.setCenter(gridPane);

        GridPane.setVgrow(root, Priority.ALWAYS);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
