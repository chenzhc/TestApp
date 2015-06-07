package com.test.app.fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.nio.ch.sctp.SctpNet;

import javax.script.ScriptEngineManager;

/**
 * Created by zc on 15-6-7.
 */
public class ChanpingTextFonts extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 2 Changing Text Fonts");

        System.out.println("Font families: " );
        Font.getFamilies()
                .stream()
                .forEach(i->System.out.println(i));
        System.out.println("Font names: ");
        Font.getFontNames()
                .stream()
                .forEach(i -> System.out.println(i));

        Group root = new Group();
        Scene scene = new Scene(root,580,250, Color.WHITE);

        Text text2 = new Text(50,50,"JavaFX 8: Intro. by Example ");
        Font serif = Font.font("Serif",30);
        text2.setFont(serif);
        text2.setFill(Color.RED);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50,50,50,.588));
        text2.setEffect(dropShadow);
        root.getChildren().add(text2);

        Text text3 = new Text(50,100,"JavaFX 8: Intro. by Example ");
        Font sanSerif = Font.font("SanSerif",30);
        text3.setFont(sanSerif);
        text3.setFill(Color.BLUE);
        root.getChildren().add(text3);

        Text text4 = new Text(50,150, "JavaFX 8: Intro. by Example ");
        Font dialogFont = Font.font("Dialog",30);
        text4.setFont(dialogFont);
        text4.setFill(Color.rgb(0,255,0));
        root.getChildren().add(text4);

        Text text5 = new Text(50,200,"JavaFX 8: Intro. by Example ");
        Font monoFont = Font.font("Monospaced",30);
        text5.setFont(monoFont);
        text5.setFill(Color.BLACK);
        root.getChildren().add(text5);

        Reflection refl = new Reflection();
        refl.setFraction(0.8f);
        refl.setTopOffset(5);
        text5.setEffect(refl);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}