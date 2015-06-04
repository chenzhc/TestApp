package com.test.app.fx.hello;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-4.
 */
public class HelloFxApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Label nameLbl = new Label("Enter your name: " );
        final TextField nameFld = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");

        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");

        sayHelloBtn.setOnAction(e -> {
            String name = nameFld.getText();
            if(name.trim().length()>0){
                msg.setText("Hello " + name);
            } else {
                msg.setText("Hello there");
            }
        });

        exitBtn.setOnAction(e -> Platform.exit());

        stage.setTitle("Hello JavaFX Application");

        VBox root = new VBox();
        root.setSpacing(5);
        root.getChildren().addAll(nameFld,nameLbl,
                msg,sayHelloBtn,exitBtn);

        Scene scene = new Scene(root,350,200);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
