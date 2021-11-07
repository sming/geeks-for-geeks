public class Solution {


    public static void main(String args[])
    {
        RatMaze rat = new RatMaze();
        int maze[][] = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } };

        rat.solveMaze(maze);
    }
}
