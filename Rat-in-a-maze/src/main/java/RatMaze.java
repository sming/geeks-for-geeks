public class RatMaze {
    private static final int DEAD_END = 0;
    private static final int OK = 1;

    private int[][] solution;
    private int[][] maze;
    private int mazeLength;

    /**
     * This is the API/entry point of the class. It sets up the context for recursion.
     * @param maze the maze we are given to find a path through
     */
    public void solveMaze(int[][] maze) {
        this.maze = maze;
        mazeLength = maze.length;
        solution = new int[maze.length][maze.length];
        solution[0][0] = 1;
        if (!solve(0, 0)) {
            System.out.println("No solution to the maze");

        }
        printSolution(solution);
    }

    /**
     * Recursive function that steps down and across to find a path through the maze. If it reaches
     * a dead end, it backtracks.
     * @param col the current column of the square being evaluated
     * @param row the current row of the square being evaluated
     * @return true if the path taken from this method call is a valid path, or if it is the goal
     * square at the end of the maze.
     */
    private boolean solve(int col, int row) {
        if (col == mazeLength - 1 && row == mazeLength - 1)
            return true;

        if (row + 1 < mazeLength && col < mazeLength && maze[col][row + 1] == OK) {
            solution[col][row + 1] = OK;
            if (solve(col, row + 1)) {
                return true;
            } else {
                solution[col][row + 1] = DEAD_END;
            }
        }

        if (col + 1 < mazeLength && row < mazeLength && maze[col + 1][row] == OK) {
            solution[col + 1][row] = OK;
            if (solve(col + 1, row)) {
                return true;
            } else {
                solution[col + 1][row] = DEAD_END;
            }
        }

        return false; // neither step was OK, hence we return false.
    }

    void printSolution(int[][] solution)
    {
        for (int i = 0; i < mazeLength; i++) {
            for (int j = 0; j < mazeLength; j++)
                System.out.print(" " + solution[i][j]
                    + " ");
            System.out.println();
        }
    }

}
