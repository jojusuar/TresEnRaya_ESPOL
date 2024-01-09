/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.proyecto2_estructuras;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import modelo.Board;
import modelo.Circle;
import modelo.Cross;
import modelo.Symbol;

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
    
    private Board tableroActual;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Temporalmente, la carga se realiza al presionar la primera casilla
        //y se limpia con la segunda
        Board prueba = new Board();
        prueba.getCells()[0][0] = new Cross();
        prueba.getCells()[0][1] = new Circle();
        prueba.getCells()[0][2] = new Cross();
        prueba.getCells()[1][1] = new Cross();
        prueba.getCells()[1][2] = new Circle();
        prueba.getCells()[2][1] = new Circle();
        tableroActual = prueba;
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
    
    @FXML
    public void loadBoard(){
        wipe();
        Board board = tableroActual;
        int cont = 0;
        Symbol[][] celdas = board.getCells();
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[1].length; j++) {
                Symbol s = celdas[i][j];
                if(celdas[i][j] instanceof Circle){
                    System.out.print("O  ");
                    //System.out.print(cont+"  ");
                    Circle c = (Circle) s;
                    try {
                        //dependiendo la version, el "src/" es necesario o no
                        //si no compila, eliminarlo
                        FileInputStream input = new FileInputStream("src/"+c.getPath());
                        Image imagen = new Image(input);
                        ImageView imageView = new ImageView(imagen);
                        imageView.setFitWidth(80);
                        imageView.setFitHeight(80);
                        getButton(cont).setGraphic(imageView);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    cont++;
                }else if(celdas[i][j] instanceof Cross){
                    System.out.print("X  ");
                    //System.out.print(cont+"  ");
                    Cross c = (Cross) s;
                    try {
                        FileInputStream input = new FileInputStream("src/"+c.getPath());
                        Image imagen = new Image(input);
                        ImageView imageView = new ImageView(imagen);
                        imageView.setFitWidth(80);
                        imageView.setFitHeight(80);
                        getButton(cont).setGraphic(imageView);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    cont++;
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
            cont++;
        }
    }
    
    public Button getButton(int i){
        //podria hacerse con Switch cases pero da problemas
        if(i == 0){
            return button1;
        }else if(i == 1){
            return button2;
        }else if(i == 2){
            return button3;
        }else if(i == 3){
            return button4;
        }else if(i == 4){
            return button5;
        }else if(i == 5){
            return button6;
        }else if(i == 6){
            return button7;
        }else if(i == 7){
            return button8;
        }else if(i == 8){
            return button9;
        }
        return null;
    }
    
     @FXML
    public void wipe(){
        for (int i = 0; i < 9; i++) {
            getButton(i).setGraphic(null);
        }
    }
    
}
