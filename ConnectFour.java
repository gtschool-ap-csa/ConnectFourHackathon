public class ConnectFour {
    public static final String empty = "\uD83D\uDFE6", redToken = "\uD83D\uDFE5", yellowToken = "\uD83D\uDFE8";

    public static int enterMove(String[][] board, String color, int col) {
        //Precondition: There is at least one open spot in col
        //board is 6 rows & 7 columns. color is "r" or "y", col is 0-6
        //Enter redToken or yellowToken into the correct spot
        //Return the row that the token landed in

        //YOUR CODE HERE
        return 0;
    }

    public static boolean checkWin(String[][] board, int row, int col) {
        //board is 6 rows & 7 columns. The given row and col are the last played position.
        //Check for four+ of the same color token in a row
        //Return true if there is a win

        //YOUR CODE HERE
        return false;
    }
}
