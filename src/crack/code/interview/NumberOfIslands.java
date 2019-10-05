package crack.code.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}};
       // System.out.println("---Results:---" + result);
        printArray(grid);
        System.out.println("---Results:---" + numIslands(grid));
        printArray(grid);
    }

    public static void printArray(char[][] grid) {

        for (int m=0; m < grid.length; m++) {

            for (int n = 0; n < grid[0].length; n++) {
                System.out.print("|"+grid[m][n]+"|");
            }
            System.out.println("\n");
        }
    }

    public static int numIslands(char[][] grid) {

        int numberIslands = 1;
        for (int m=0; m < grid.length; m++){
            for (int n=0; n < grid[0].length; n++){
                if (grid[m][n] == '1') {
                    //Land found
                    grid[m][n] = (char) ((numberIslands + 1) + '0');
                    searchValueInGrid(grid, m, n, '1', grid[m][n]);
                    numberIslands = numberIslands + 1;
                }
            }
         }

        return numberIslands - 1;
    }

    public static boolean searchValueInGrid(char[][] grid, int m, int n, char value, char newValue) {

        //Check Right
        if (isPositionValid(grid, m, n + 1) && grid[m][n + 1] == value) {
            //item found
            grid[m][n + 1] = newValue;
            searchValueInGrid(grid, m, n +1, value, newValue);
        }
        //Check Left
        if (isPositionValid(grid, m, n - 1) && grid[m][n - 1] == value) {
            //item found
            grid[m][n - 1] = newValue;
            searchValueInGrid(grid, m, n - 1, value, newValue);
        }
        //Check Down
        if (isPositionValid(grid, m + 1, n ) && grid[m + 1][n] == value) {
            //item found
            grid[m + 1][n] = newValue;
            searchValueInGrid(grid, m + 1, n, value, newValue);
        }
        //Check Up
        if (isPositionValid(grid, m - 1, n ) && grid[m - 1][n] == value) {
            //item found
            grid[m - 1][n] = newValue;
            searchValueInGrid(grid, m - 1, n, value, newValue);
        }
        return false;
    }

    public static boolean isPositionValid(char[][] grid, int m, int n) {

        if (n < 0 || n >= grid[0].length) {
            return false;
        }
        if (m < 0 || m >= grid.length) {
            return false;
        }
        return true;
    }
}
