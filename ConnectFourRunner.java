import java.util.Arrays;
import java.util.Scanner;

public class ConnectFourRunner {
    public static final String ANSI_RESET = "\033[0m", ANSI_BLUE = "\033[0;34m";
    public static String[][] board = new String[6][7];
    public static final String empty = "\uD83D\uDFE6", redToken = "\uD83D\uDFE5", yellowToken = "\uD83D\uDFE8";
    public static String playerOneColor, playerTwoColor;
    public static int round;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (String[] row : board) {
            Arrays.fill(row, empty);
        }
        //choose color
        while (true) {
            System.out.print("Player 1: Do you want to play as red or yellow? (r/y): ");
            String input = sc.nextLine();
            if (input.equals("r")) {
                playerOneColor = "r";
                playerTwoColor = "y";
                break;
            } else if (input.equals("y")) {
                playerOneColor = "y";
                playerTwoColor = "r";
                break;
            }
            System.out.println("Invalid input: Enter r or y only.");
        }
        //run game
        while (++round < 43) {
            printBoard();
            int playerNum = round % 2;
            if (playerNum == 0) playerNum = 2;
            //Enter move
            int col;
            while (true) {
                String emoji = playerNum == 1 ? (playerOneColor.equals("r") ? redToken : yellowToken) : (playerTwoColor.equals("r") ? redToken : yellowToken);
                System.out.print("Enter move for Player " + playerNum + " " + emoji + " (1-7): ");
                String input = sc.nextLine();
                try {
                    int n = Integer.parseInt(input);
                    if (0 < n && n < 8 && board[0][n - 1].equals(empty)) {
                        col = n - 1;
                        break;
                    }
                } catch (Exception ignored) {
                }
                System.out.println("Invalid input. Either you did not enter 1-7 or the column was full.");
            }
            int row = ConnectFour.enterMove(board, playerNum == 1 ? playerOneColor : playerTwoColor, col);
            //Check win
            if (ConnectFour.checkWin(board, row, col)) {
                printBoard();
                System.out.println("Player " + playerNum + " wins!");
                System.exit(0);
            }
        }
        printBoard();
        System.out.println("There was a tie!");
    }

    public static void printBoard() {
        for (String[] row : board) {
            System.out.println(ANSI_BLUE + Arrays.toString(row).replaceAll("\\[", "| ").replaceAll("[],]", "|").replaceAll(" ", "") + ANSI_RESET);
        }
        System.out.println(" 1\uFE0F⃣ 2\uFE0F⃣ 3\uFE0F⃣ 4\uFE0F⃣ 5\uFE0F⃣ 6\uFE0F⃣ 7\uFE0F⃣");
    }
}
