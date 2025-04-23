//percys code

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuBoard {

    private int[][] board;

    public SudokuBoard(String filename) {
        board = new int[9][9];
        try {
            Scanner file = new Scanner(new File(filename));
            for (int r = 0; r < 9; r++) {
                String line = file.nextLine();
                for (int c = 0; c < 9; c++) {
                    char ch = line.charAt(c);
                    if (ch == '.') {
                        board[r][c] = 0;
                    } else {
                       board[r][c] = ch - '0';
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file: " + filename);
        }
    }
    

    public boolean isValid(){
        return (validCharacters() && checkDuplicate());
    }
    
    private boolean validCharacters(){
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[0].length; c++) {
            int i = board[r][c];
            if(!(i >= 0 || i <= 9)){ // if its a number 0-9 or is '.'
                System.out.println("invalid character");
                return false;
            }
         }
      }
      return true;
    }
    
    public boolean checkDuplicate() {
      
      //row
      for(int r = 0; r < board.length; r++) {
         Set<Integer> set = new HashSet<Integer>();
         for(int c = 0; c < board[0].length; c++) {
         
            int num = board[r][c];
            
            if(num != 0){ // if the num isn't blank, count it as a number
               if(set.contains(num)){ // if the number is already in the set
                   System.out.println("duplicate number in row " + r); // theres a duplicate
                   return false;
               } else { // if its not
                  set.add(num); // add it to the set
               }
            }
            
         }
      }
      
      //columns
      for(int c = 0; c < board[0].length; c++) {
         Set<Integer> set = new HashSet<Integer>();
         for(int r = 0; r < board.length; r++) {
         
            int num = board[r][c];
            
            if(num != 0){ // if the num isn't blank, count it as a number
               if(set.contains(num)){ // if the number is already in the set
                   System.out.println("duplicate number in column " + c); // theres a duplicate
                   return false;
               } else { // if its not
                  set.add(num); // add it to the set
               }
            }
            
         }
      }
      
      // blocks
      for(int s = 1; s <= 9; s++){ // go through spots 1-9
         Set<Integer> set = new HashSet<Integer>();
         int[][] minisquare = miniSquare(s);
         for(int c = 0; c < minisquare[0].length; c++) {   
            for(int r = 0; r < minisquare.length; r++) {
               int num = minisquare[r][c];
               if(num != 0){ // if the num isn't blank, count it as a number
                  if(set.contains(num)){ // if the number is already in the set
                      System.out.println("duplicate number in mini square " + s); // theres a duplicate
                      return false;
                  } else { // if its not
                     set.add(num); // add it to the set
                  }
               }
            }
         }
      }
      
      return true;
    }
    
    private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }

    public String toString() {
      String result = "";
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[0].length; c++) {
            if(board[r][c] == 0) {
               result += "X ";   
            } else {
               result += board[r][c] + " ";
            }
         }
         result += "\n";
      }

      return result;
    }
 
 
 }
 
 /*
 2 X X 1 X 5 X X 3 
X 5 4 X X X 7 1 X 
X 1 X 2 X 3 X 8 X 
6 X 2 8 X 7 3 X 4 
X X X X X X X X X 
1 X 5 3 X 9 8 X 6 
X 2 X 7 X 1 X 6 X 
 */