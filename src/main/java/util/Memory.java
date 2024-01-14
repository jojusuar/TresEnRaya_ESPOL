/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import modelo.Board;

/**
 *
 * @author euclasio
 */
public class Memory {

    private static List<Board> boards = new LinkedList<>();

    public static void addBoard(Board board) {
        boards.add(board);
    }

    public static void deleteBoard(Board board) {
        boards.remove(board);
    }

    public static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/memory/games.ser"));) {
            out.writeObject(boards);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void load() {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("src/main/resources/memory/games.ser"));) {
            boards = (LinkedList<Board>) in.readObject();
        } catch (IOException ex) {
            System.out.println("No hay juegos que cargar");
            boards = new LinkedList<>();
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró la clase Board");
        }
    }
}
