package modelo;


import estructuras.Tree;
import modelo.Board;
import modelo.MinMaxer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author euclasio
 */
public class TestZone {
    public static void main(String[] args){
        Board emptyBoard = new Board();
        Tree<Board> tree = MinMaxer.minmax(emptyBoard);
        
        System.out.println(tree);
    }
}
