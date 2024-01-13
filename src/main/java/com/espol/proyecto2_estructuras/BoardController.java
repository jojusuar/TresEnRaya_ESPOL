/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.proyecto2_estructuras;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import modelo.Board;
import modelo.Circle;
import modelo.Cross;
import modelo.Symbol;
import util.Memory;

/**
 * FXML Controller class
 *
 * @author euclasio
 */
public class BoardController implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private FlowPane tableroVisible;

    private static Board tableroActual;

    private Button[][] grid;

    private Symbol cross;

    private Symbol circle;

    private boolean crossTurn;

    private boolean againstComputer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //la logica del juego esta definida al 100% para jugador vs jugador.
        //Dejo agregado el atributo againstComputer, para mantener el comportamiento actual del programa
        //cuando se seleccione una opcion de jugar contra otro humano en el menu de pre-juego.
        //
        //ahora se debe escribir el minmaxer para que la computadora responda
        //

        grid = new Button[3][3];
        Random random = new Random();
        crossTurn = random.nextBoolean();
        cross = new Cross();
        circle = new Circle();
        setButtonPos(button1, 0, 0);
        setButtonPos(button2, 1, 0);
        setButtonPos(button3, 2, 0);
        setButtonPos(button4, 0, 1);
        setButtonPos(button5, 1, 1);
        setButtonPos(button6, 2, 1);
        setButtonPos(button7, 0, 2);
        setButtonPos(button8, 1, 2);
        setButtonPos(button9, 2, 2);
    }

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    public void input() {
        System.out.println();
    }

    public void showBoard() {
        Symbol[][] cells = tableroActual.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j] != null) {
                    Symbol s = cells[i][j];
                    if (s instanceof Circle) {
                        Circle c = (Circle) s;
                        setSymbol(c, i, j);
                    } else if (s instanceof Cross) {
                        Cross c = (Cross) s;
                        setSymbol(c, i, j);
                    }
                }
            }
        }
    }

    public void setButtonPos(Button b, int x, int y) {
        grid[x][y] = b;
        b.setOnAction(ev -> {
            tableroActual.nextTurn();
            if (tableroActual.getCells()[x][y] != null) {
                return;
            }
            Symbol symbol = cross;
            if (!crossTurn) {
                symbol = circle;
            }
            tableroActual.getCells()[x][y] = symbol;
            crossTurn = !crossTurn;
            showBoard();
            checkGame();
        });
    }

    private void checkGame() {
        int winner = tableroActual.checkBoard();
        switch (winner) {
            case 1:
                endGame("Ganador: CIRCULO");
                return;
            case 2:
                endGame("Ganador: CRUZ");
                return;
            default:
                break;
        }
        if (tableroActual.getTurnsLeft() == 0) {
            endGame("Empate");
        }
    }

    public void endGame(String outcome) {
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Fin del juego");
        informationAlert.setHeaderText(outcome);
        informationAlert.showAndWait();
        try {
            switchToMenu();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setSymbol(Symbol c, int i, int j) {
        try {
            //dependiendo la version, el "src/" es necesario o no
            //si no compila, eliminarlo
            FileInputStream input = new FileInputStream("src/" + c.getPath());
            Image imagen = new Image(input);
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            grid[i][j].setGraphic(imageView);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    ////creo que no se necesita con los cambios que hice a la logica
    public Button getButton(int i) {
        if (i == 0) {
            return button1;
        } else if (i == 1) {
            return button2;
        } else if (i == 2) {
            return button3;
        } else if (i == 3) {
            return button4;
        } else if (i == 4) {
            return button5;
        } else if (i == 5) {
            return button6;
        } else if (i == 6) {
            return button7;
        } else if (i == 7) {
            return button8;
        } else if (i == 8) {
            return button9;
        }
        return null;
    }
    
    @FXML
    public void saveGame(){
        TextInputDialog dialog = new TextInputDialog("Guardar tablero actual");
        dialog.setTitle("Guardar");
        dialog.setHeaderText("Ingrese el nombre de la partida a guardar:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(text -> tableroActual.setDescription(text));
        Memory.addBoard(tableroActual);
        Memory.save();
    }
    
    public static void setTableroActual(Board b) {
        tableroActual = b;
    }
    ///creo que innecesario tambien
    @FXML
    public void wipe() {
        for (int i = 0; i < 9; i++) {
            getButton(i).setGraphic(null);
        }
    }

}
