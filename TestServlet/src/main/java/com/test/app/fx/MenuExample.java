package com.test.app.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Created by zc on 15-6-7.
 */
public class MenuExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Menus Example");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,300,250, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem,
                saveMenuItem,
                new SeparatorMenuItem(),
                exitMenuItem);

        menuBar.getMenus().add(fileMenu);

        Menu cameraMenu = new Menu("Cameras");
        CheckMenuItem cam1MenuItem = new CheckMenuItem("Show Camera");
        cam1MenuItem.setSelected(true);
        cameraMenu.getItems().add(cam1MenuItem);

        CheckMenuItem cam2MenuItem = new CheckMenuItem("Show Camera");
        cam2MenuItem.setSelected(true);
        cameraMenu.getItems().add(cam2MenuItem);

        menuBar.getMenus().add(cameraMenu);

        Menu alarmMenu = new Menu("Alarm");

        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem soundAlarmItem = new RadioMenuItem("Sound Alarm");
        soundAlarmItem.setToggleGroup(tGroup);

        RadioMenuItem stopAlarmItem = new RadioMenuItem("Alarm Off");
        stopAlarmItem.setToggleGroup(tGroup);
        stopAlarmItem.setSelected(true);

        alarmMenu.getItems().addAll(soundAlarmItem,
                stopAlarmItem,
                new SeparatorMenuItem());

        Menu contingencyPlans = new Menu("Contingent Plans");
        contingencyPlans.getItems().addAll(
                new CheckMenuItem("Self Destruct in T Minus 50"),
                new CheckMenuItem("Turn off the coffee machine "));
        alarmMenu.getItems().add(contingencyPlans);

        menuBar.getMenus().add(alarmMenu);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
