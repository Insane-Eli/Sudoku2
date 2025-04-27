public class SudokuEngine {
    public static void main(String[] args) {
        SudokuBoard myBoard = new SudokuBoard("boards/valid-complete.sdk");
        System.out.println("the board is valid: " + myBoard.isValid());
        System.out.println("the board is solved: " + myBoard.isSolved());
        System.out.println(myBoard);

        SudokuBoard myBoard2 = new SudokuBoard("boards/valid-incomplete.sdk");
        System.out.println("the board is valid: " + myBoard2.isValid());
        System.out.println("the board is solved: " + myBoard2.isSolved());
        System.out.println(myBoard2);
    }
}