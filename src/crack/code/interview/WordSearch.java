package crack.code.interview;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
public class WordSearch {


    public static void main(String[] args) {
/*
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        boolean result = exist(board, "ABCCED");


        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};

        boolean result = exist(board, "AAB");


        char[][] board = {
                {'A','A','A','A'},
                {'A','A','A','A'},
                {'A','A','A','A'}};

        boolean result = exist(board, "AAAAAAAAAAAA");




        char[][] board = {
                {'B','A','B'},
                {'B','B','A'},
                {'B','B','B'}};

        boolean result = exist(board, "AB");
          */
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};

        boolean result = exist(board, "ABCESEEEFS");




        System.out.println("---Results:---" + result);
    }

    public static boolean exist(char[][] board, String word) {

        boolean result = false;

        int n = board[0].length;
        int m = board.length;
        int i = 0;

        int totalBoardLength = n * m;

        if (word.length() > totalBoardLength) {
            return false;
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {

                //Char exists, check if other chars also exists
                if (board[y][x] == word.charAt(i)) {

                    boolean[][] path = new boolean[board.length][board[0].length];

                    result =  isNextCharValid(x, y, board, word, 1, path);

                    if (result) {
                        return true;
                    }
                }
            }
        }



        return result;
    }


    public static boolean isNextCharValid(int n, int m, char[][] board, String value, int nextIndex, boolean[][] path) {


        boolean res = false;
        int indexToLookFor = nextIndex;

        if (isValid(n, m, board)) {
            path[m][n] = true;
        }

        if (indexToLookFor == value.length()) {
            return true;
        }

        if ( isValidWithPath(n+1,m, board, path)  && board[m][n+1] == value.charAt(indexToLookFor)) {
            //Check Right
            res =  isNextCharValid(n+1, m, board, value, (nextIndex + 1), path);
        }
        if ( !res && isValidWithPath(n - 1,m, board, path)  &&  board[m][n-1] == value.charAt(indexToLookFor)) {
            //Check Left
            res =  isNextCharValid(n-1, m, board, value, (nextIndex + 1), path);
        }
        if ( !res && isValidWithPath(n ,m - 1, board, path)  &&  board[m - 1][n] == value.charAt(indexToLookFor)) {
            //Check Up
            res =  isNextCharValid(n, m - 1, board, value, (nextIndex + 1), path);
        }
        if ( !res && isValidWithPath(n,m + 1, board, path)  &&  board[m + 1][n] == value.charAt(indexToLookFor)) {
            //Check Down
            res =  isNextCharValid(n, m + 1, board, value, (nextIndex + 1), path);
        }

        path[m][n] = false;
        return res;
    }

    private static boolean isValidWithPath(int n, int m, char[][] board, boolean[][] path) {

        //check that the point is not in the path already

        if (isValid(n, m, board)) {
            if (path[m][n]){
                return false;
            }
            return true;
        }
        return false;

    }

    private static boolean isValid(int n, int m, char[][] board) {

        if (n >= 0 && n < board[0].length) {
            if (m >= 0 && m < board.length) {
                return true;
            }
        }
        return false;
    }
}
