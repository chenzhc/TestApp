package com.test.app.fx;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by zc on 15-6-7.
 */
public class FormValidation extends Application {
    private final static String MY_PASS = "password1";
    private final static BooleanProperty GRANTED_ACCESS = new SimpleBooleanProperty(false);
    private final IntegerProperty ATTEMPTS = new SimpleIntegerProperty(0);
    private final static int MAX_ATTEMPTS = 3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        User user = new User();

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Group root = new Group();
        Scene scene = new Scene(root,320,112, Color.rgb(0,0,0,0));
        primaryStage.setScene(scene);

        Color foregroundColor = Color.rgb(255,255,255,.9);

        Rectangle background = new Rectangle(320,112);
        background.setX(0);
        background.setY(0);
        background.setArcHeight(15);
        background.setArcWidth(15);
        background.setFill(Color.rgb(0,0,0,.55));
        background.setStrokeWidth(1.5);
        background.setStroke(foregroundColor);

        Text userName = new Text();
        userName.setFont(Font.font("SanSerif", FontWeight.BOLD,30));
        userName.setFill(foregroundColor);
        userName.setSmooth(true);
        userName.textProperty()
                .bind(user.userNameProperty());

        HBox userNameCell = new HBox();
        userNameCell.prefWidthProperty()
                .bind(primaryStage.widthProperty().subtract(45));
        userNameCell.getChildren().add(userName);

        HBox row1 = new HBox();
        row1.getChildren().addAll(userNameCell);

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(Font.font("SanSerif",20));
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-text-fill:black; "
                + "-fx-prompt-text-fill: gray; "
                + "-fx-highlight-text-fill: black; "
                + "-fx-highlight-fill: gray; "
                + "-fx-background-color: rgba(255,255,255,.80); ");
        passwordField.prefWidthProperty()
                .bind(primaryStage.widthProperty().subtract(55));
        user.passwordProperty().bind(passwordField.textProperty());

        VBox formLayout = new VBox(4);
        formLayout.getChildren().addAll(row1);
        formLayout.setLayoutY(12);
        formLayout.setLayoutX(12);


        root.getChildren().addAll(background,formLayout);

        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
