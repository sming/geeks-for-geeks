import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens
 * attack each other. For example, following is a solution for 4 Queen problem. Backtracking
 * Algorithm
 *
 * <p>The idea is to place queens one by one in different columns, starting from the leftmost
 * column. When we place a queen in a column, we check for clashes with already placed queens. If we
 * find a row for which there is no clash, we mark this row and column as part of the solution. If
 * we do not find such a row due to clashes then we backtrack and return false.
 *
 * <p>1) Start in the leftmost column 2) If all queens are placed return true 3) Try all rows in the
 * current column. Do following for every tried row. a) If the queen can be placed safely in this
 * row then mark this [row, column] as part of the solution and recursively check if placing queen
 * here leads to a solution. b) If placing the queen in [row, column] leads to a solution then
 * return true. c) If placing queen doesn't lead to a solution then unmark this [row, column]
 * (Backtrack) and go to step (a) to try other rows. 3) If all rows have been tried and nothing
 * worked, return false to trigger backtracking.
 *
 * <p>Diagonals 0 0 0 1 0 0 1 0 0 1 0 0 1 0 0 0 if +1, +1 is used, return false if -1, -1 is used,
 * return false 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0 1 if +1, -1 is used, return false if -1, +1 is used,
 * retu...
 *
 * <p>So, it's, from the starting square: if [i+1,j+1] || [i-1,j-1] || [i+1,j-1] || [i-1,j+1] is
 * used return false
 *
 * <p>but how do we stop Array out of bounds?
 */
class Solution {
  private static Integer FREE = 0;
  private static Integer USED = 1;
  private static ArrayList<ArrayList<Integer>> board;
  private static int numQueens;
  private static int queenCount;
  // **columns of rows i.e. outer list is columns, inner is rows***
  static ArrayList<ArrayList<Integer>> nQueen(int numQueens) {
    Solution.numQueens = numQueens;
    board = buildBoard(numQueens);
    doit(0);
    return board;
  }

  private static boolean doit(int col) {
    if (col >= numQueens)
      return true;

    for (int j = 0; j < numQueens; j++) {
      //      if (canQueenBePlacedHere(col, j)) {
      var doop = new int[numQueens][numQueens];
      for(int i = 0; i < numQueens; i++) {
        var row = board.get(i).stream().mapToInt(Integer::intValue).toArray();
        doop[i] = row;
      }

      if (isSafe(doop, j, col)) {
        board.get(col).set(j, USED);
        var res = doit(col + 1);
        if (!res) {
          board.get(col).set(j, FREE);
        }
      }
    }

    // if we reach here then we were unable to place numQueens Queens, so we backtrack
    return false;
  }

  static void printSolution(int board[][])
  {
    for (int i = 0; i < numQueens; i++) {
      for (int j = 0; j < numQueens; j++)
        System.out.print(" " + board[i][j]
            + " ");
      System.out.println();
    }
  }
  private static boolean isSquareOnBoard(int col, int row) {
    return row < numQueens && row >= 0 && col < numQueens && col >= 0;
  }

  private static boolean isSquareUsed(int col, int row) {
    if (!isSquareOnBoard(col, row)) return false;

    return board.get(row).get(col).equals(USED);
  }

  /**
   * copied from https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
   * @param board
   * @param row
   * @param col
   * @return
   */
  static boolean isSafe(int board[][], int row, int col)
  {
    int i, j;

    /* Check this row on left side */
    for (i = 0; i < col; i++)
      if (board[row][i] == 1)
        return false;

    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
      if (board[i][j] == 1)
        return false;

    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < numQueens; i++, j--)
      if (board[i][j] == 1)
        return false;

    return true;
  }

  private static boolean canQueenBePlacedHere(int col, int row) {
    // check same row
    for (int i = 0; i < numQueens; i++) { // columns
      if (board.get(i).get(row).equals(USED)) return false;
    }

    // check column
    for (int i = 0; i < numQueens; i++) { // columns
      if (board.get(col).get(i).equals(USED)) return false;
    }

    // check diagonals
    for (int i = 1; i < numQueens; i++) {
      if (isSquareUsed(row + i, col + i)
          || isSquareUsed(row + i, col - i)
          || isSquareUsed(row - i, col + i)
          || isSquareUsed(row - i, col - i)) return false;
    }

    return true;
  }

  private static ArrayList<ArrayList<Integer>> buildBoard(int n) {
    var board = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < n; i++) {
      var row = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        row.add(0);
      }
      board.add(row);
    }
    return board;
  }
}
