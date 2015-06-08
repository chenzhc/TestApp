package com.test.app.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 * Created by zc on 15-6-8.
 */
public class BuilderApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = SceneBuilder.create()
                .width(300)
                .height(100)
                .root(VBoxBuilder.create()
                    .children(LabelBuilder.create()
                        .text("Hello Builder").build(),
                                ButtonBuilder.create()
                                        .text("Exit")
                                        .onAction(e -> Platform.exit())
                                        .build())
                        .build())
                .build();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Builder Classes");
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
