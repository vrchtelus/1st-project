package games.ttt;
import java.util.Scanner;

public class ttt {

    public static void main(String[] args) {
        Scanner userInputReader = new Scanner(System.in);

        board board = new board();
        board.instructionBoard();
        System.out.println("Please enter a position:");
        int position = userInputReader.nextInt();
        board.placePieceX(position, "X");

        boolean isGameInProgress = true;

        while( isGameInProgress && !board.isFull()){

            board.placePiece0("O");
            board.displayBoard();
            System.out.println("Please enter a position for X:");
            position = userInputReader.nextInt();
            board.placePieceX(position, "X");
            isGameInProgress = gameResolver.resolve(board.getBoard())==gameResolver.GameState.IN_PROGRESS;
            board.displayBoard();

        }
        if(!isGameInProgress) {
            board.displayBoard();
            System.out.print(" GAME OVER!!!");
        }
        else board.displayBoard();
    }
}
