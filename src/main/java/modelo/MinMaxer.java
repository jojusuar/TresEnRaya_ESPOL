/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author euclasio
 */
public class MinMaxer {

    private static Tree<Board> possibilities;
    private static List<Tree<Board>> history = new LinkedList<>();

    public static Tree<Board> minmax(Board current) {
        possibilities = new Tree<>();
        possibilities.setCmp(Board.comparator());
        possibilities.setRoot(current);
        //madre bendita O(n^4)
        Symbol[][] currentCells = possibilities.getRoot().getCells();
        for (int i = 0; i < currentCells.length; i++) {
            for (int j = 0; j < currentCells.length; j++) {
                if (currentCells[i][j] == null) {
                    Board level1 = current.getCopy();
                    Symbol symbol = new Cross();
                    if (!GameMaster.isCrossTurn()) {
                        symbol = new Circle();
                    }
                    level1.getCells()[i][j] = symbol;
                    possibilities.add(current, level1);
                    GameMaster.setCrossTurn(!GameMaster.isCrossTurn());
                    Symbol[][] level1cells = level1.getCells();
                    for (int x = 0; x < level1cells.length; x++) {
                        for (int y = 0; y < level1cells.length; y++) {
                            if (level1cells[x][y] == null) {
                                Board level2 = level1.getCopy();
                                Symbol symbol2 = new Cross();
                                if (!GameMaster.isCrossTurn()) {
                                    symbol2 = new Circle();
                                }
                                level2.getCells()[x][y] = symbol2;
                                possibilities.add(level1, level2);

                            }
                        }
                    }
                    //se me ocurre iterar sobre los hijos de cada tablero de nivel 1 y reemplazarlo cada vez que un hijo tenga utilidad menor
                }
            }
        }
        //TODO: calculo de utilidad
        return possibilities;
    }
}
