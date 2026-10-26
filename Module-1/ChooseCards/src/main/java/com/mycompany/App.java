package com.mycompany;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane(); // Main Container
        HBox cardBox = new HBox(15); // Card Image Container
        HBox btnBox = new HBox(); // Button Container
        
        // Creates ArrayList of the cards in the deck.
        ArrayList<Integer> deck = new ArrayList<>(54);
        for (int i = 1; i<=54; i++) {
            deck.add(i);
        }
        
        //Creates button and places it in container.
        Button btn = new Button("Choose New Cards");
        btnBox.getChildren().add(btn);
        
        // Lambda Expression to tell button what to do.
        btn.setOnAction(e -> {
            cardBox.getChildren().clear(); // Empties cardBox.
            Collections.shuffle(deck); // Randomizes deck images.
            //Chooses the first four numbers in deck and displays each.
            for (int i = 0; i < 4; i++) {
                int cardNum = deck.get(i);
                String imagePath = getClass().getResource(
                        "/cards/" + cardNum + ".png").toExternalForm();
                Image cardImage = new Image(imagePath);
                ImageView imageView = new ImageView(cardImage);
                cardBox.getChildren().add(imageView);
            }
        });
        
        // Adds all nodes to root container in proper alignment.
        root.setCenter(cardBox);
        root.setBottom(btnBox);
        cardBox.setAlignment(Pos.CENTER);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setPadding(new Insets(15));
        
        btn.fire(); // Initial click to choose first cards.
        
        // Sets the Scene, Title, and then displays.
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Choose Four Random Cards");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(); // Runs the program.
    }
}