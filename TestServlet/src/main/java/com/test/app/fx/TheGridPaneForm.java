package com.test.app.fx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by zc on 15-6-7.
 */
public class TheGridPaneForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GridPaneForm");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,380,150, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(50,150,300);
        column2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1,column2);

        Label fNameLb1 = new Label("First Name");
        TextField fNameFld = new TextField();
        Label lNameLbl = new Label("Last Name");
        TextField lNameFld = new TextField();

        Button saveBtn = new Button("Save");

        GridPane.setHalignment(fNameLb1, HPos.RIGHT);
        gridPane.add(fNameLb1,0,0);

        GridPane.setHalignment(lNameLbl,HPos.RIGHT);
        gridPane.add(lNameLbl,0,1);

        GridPane.setHalignment(fNameFld,HPos.LEFT);
        gridPane.add(fNameFld,1,0);

        GridPane.setHalignment(lNameFld,HPos.LEFT);
        gridPane.add(lNameFld,1,1);

        GridPane.setHalignment(saveBtn,HPos.RIGHT);
        gridPane.add(saveBtn,1,2);

        FlowPane topBanner = new FlowPane();
        topBanner.setPrefHeight(40);
        String backgroundStyle =
                "-fx-background-color: lightblue;"
                +"-fx-background-radius: 30%;"
                +"-fx-background-inset: 5px;";
        topBanner.setStyle(backgroundStyle);


        Text contactText = new Text("Contacts");
        contactText.setFill(Color.WHITE);

        Font serif = Font.font("Dialog",30);
        contactText.setFont(serif);
        topBanner.getChildren().addAll(contactText);

        root.setTop(topBanner);
        root.setCenter(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
