/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tree;

/**
 *
 * @author euclasio
 */
public class MinMaxer {
    private static Tree<Board> possibilities;
    
    public static void minmax(Board current){
        possibilities = new Tree<>();
        possibilities.setRoot(current);
        //TODO
    }
}
