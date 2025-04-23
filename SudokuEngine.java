public class SudokuEngine {
    public static void main(String[] args) {
        SudokuBoard myBoard = new SudokuBoard("data1.sdk");
        System.out.println(myBoard.isValid());
        System.out.println(myBoard);
    }
}