/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructuras.Tree;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author euclasio
 */
public class MinMaxer {

    private static List<Tree<Board>> history = new LinkedList<>();
    private static Comparator<Board> cmpUtility = (Board b1, Board b2) -> {
        return b2.getUtility() - b1.getUtility();
    };

    public static Tree<Board> boardTreeBuilder(Board current) {
        boolean crossturn = GameMaster.isCrossTurn();
        Tree<Board> possibilities = new Tree<>();
        possibilities.setCmp(Board.comparator());
        possibilities.setRoot(current);
        Symbol[][] currentCells = possibilities.getRoot().getCells();
        Symbol symbol1 = new Cross();
        Symbol symbol2 = new Circle();
        if (!crossturn) {
            symbol1 = new Circle();
            symbol2 = new Cross();
        }
        for (int i = 0; i < currentCells.length; i++) {
            for (int j = 0; j < currentCells.length; j++) {
                if (currentCells[i][j] == null) {
                    Board level1 = current.getCopy();
                    level1.getCells()[i][j] = symbol1;
                    System.out.println(level1);
                    level1.setChoiceX(i);
                    level1.setChoiceY(j);
                    possibilities.add(current, level1);
                    Symbol[][] level1cells = level1.getCells();
                    for (int x = 0; x < level1cells.length; x++) {
                        for (int y = 0; y < level1cells.length; y++) {
                            crossturn = !crossturn;
                            if (level1cells[x][y] == null) {
                                Board level2 = level1.getCopy();
                                level2.getCells()[x][y] = symbol2;
                                possibilities.add(level1, level2);
                            }
                        }
                    }
                }
            }
        }
        history.add(possibilities);
        return possibilities;
    }

    public static <E, T> int[] minmax(Board board, Class<E> human, Class<T> computer) {
        Tree<Board> tree = boardTreeBuilder(board);
        int[] bestMoveCoordinates = new int[2];
        Queue<Board> max = new PriorityQueue(cmpUtility);
        for (Tree<Board> intermediate : tree.getSubtrees()) {
            Board intermediateBoard = intermediate.getRoot();
            int min = Integer.MAX_VALUE;
            for (Tree<Board> leaf : intermediate.getSubtrees()) {
                Board leafBoard = leaf.getRoot();
                int utility = leafBoard.utilityFunction(human, computer);
                if (utility < min) {
                    min = utility;
                }
            }
            intermediateBoard.setUtility(min);
            max.offer(intermediateBoard);
        }
        Board bestBoard = max.poll();
        System.out.println(bestBoard);
        bestMoveCoordinates[0] = bestBoard.getChoiceX();
        bestMoveCoordinates[1] = bestBoard.getChoiceY();
        return bestMoveCoordinates;
    }
}
