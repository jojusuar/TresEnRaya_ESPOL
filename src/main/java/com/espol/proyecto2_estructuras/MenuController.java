/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.proyecto2_estructuras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import modelo.Board;

/**
 * FXML Controller class
 *
 * @author euclasio
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void newGame() {
        BoardController.setTableroActual(new Board());
        try {
            switchToBoard();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void gameSettings() {
        ToggleGroup difficultyToggle = new ToggleGroup();
        ToggleGroup modeToggle = new ToggleGroup();
        RadioButton normalButton = new RadioButton("Normal");
        normalButton.setToggleGroup(difficultyToggle);
        RadioButton hardButton = new RadioButton("Difícil");
        hardButton.setToggleGroup(difficultyToggle);
        difficultyToggle.selectToggle(normalButton);
        RadioButton pvpButton = new RadioButton("Humano vs Humano");
        pvpButton.setToggleGroup(modeToggle);
        RadioButton computerButton = new RadioButton("Humano vs Computadora");
        computerButton.setToggleGroup(modeToggle);
        RadioButton autoplayButton = new RadioButton("Computadora vs Computadora");
        autoplayButton.setToggleGroup(modeToggle);
        modeToggle.selectToggle(computerButton);
        VBox difficulty = new VBox(10);
        difficulty.getChildren().addAll(new Label("Dificultad"), normalButton, hardButton);
        VBox gameMode = new VBox(10);
        gameMode.getChildren().addAll(new Label("Modo de Juego"), pvpButton, computerButton, autoplayButton);
        Stage newGameStage = new Stage();
        newGameStage.setTitle("Configuración del juegp");
        HBox settings = new HBox(40);
        settings.getChildren().addAll(difficulty, gameMode);
        settings.setAlignment(Pos.CENTER);
        VBox layout = new VBox(40);
        Button start = new Button("Jugar");
        start.setOnAction(ev -> {
            RadioButton selectedDifficulty = (RadioButton) difficultyToggle.getSelectedToggle();
            if(selectedDifficulty == hardButton){
                BoardController.setHardMode(true);
            }
            RadioButton selectedMode = (RadioButton) modeToggle.getSelectedToggle();
            if(selectedMode == computerButton){
                BoardController.setAgainstComputer(true);
            }
            else if(selectedMode == autoplayButton){
                BoardController.setAutoplay(true);
            }
            newGame();
            newGameStage.close();
        });
        layout.getChildren().addAll(settings, start);
        layout.setAlignment(Pos.CENTER);
        newGameStage.setScene(new Scene(layout, 400, 200));
        newGameStage.show();
    }

    @FXML
    private void switchToBoard() throws IOException {
        App.setRoot("board");
    }

}
