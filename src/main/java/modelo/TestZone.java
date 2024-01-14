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
public class TestZone {
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>(1);
        tree.setCmp((Integer s1, Integer s2) -> {return s1 - s2;});
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(1, 5);
        tree.add(2, 10);
        tree.printTree();
    }
}
