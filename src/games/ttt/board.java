package games.ttt;
import java.util.Random;
import java.util.Scanner;

public class board {
    // 0 means empty
    // 1 means X
    // 2 means O
    private int[][] board= new int[3][3];
    // tablero instrucciones
    public void instructionBoard(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }
    // tablero de juego
    public void displayBoard(){
        System.out.println("| - | - | - |");
        System.out.println(printBoardRow(0));
        System.out.println("| - | - | - |");
        System.out.println(printBoardRow(1));
        System.out.println("| - | - | - |");
        System.out.println(printBoardRow(2));
        System.out.println("| - | - | - |");

    }

    private String printBoardRow(int row){
        //dibujar tablero
        StringBuilder rowBuilder = new StringBuilder("| ");
        for(int i=0;i<board[0].length;i++){
            if(board[row][i] == 0) rowBuilder.append(" ");
            if(board[row][i] == 1) rowBuilder.append("X");
            if(board[row][i] == 2) rowBuilder.append("O");
            rowBuilder.append(" | ");
        }
        rowBuilder.deleteCharAt(rowBuilder.lastIndexOf(" "));
        return rowBuilder.toString();
    }
    public boolean placePieceX(int position, String pieceType){
        // numero dela posicion de la matriz, caracter a ingresar ^
        int row = (position-1)/3;
        int col = (position - (row*3))-1;
        //fila y columna en base a posicion
        if(board[row][col] == 0) {
            if (pieceType.equals("X")) board[row][col] = 1;
            if (pieceType.equals("O")) board[row][col] = 2;
            return true;
        }
        return false;
    }

    public boolean placePiece0(String pieceType){
        Scanner userInputReader = new Scanner(System.in);
        System.out.println("Please enter a position for 0:");
        int position = userInputReader.nextInt();

        int row = (position-1)/3;
        int col = (position - (row*3))-1;
        boolean wasPiecePlace = false;
        while(!wasPiecePlace && !isFull()) {
            if(board[row][col]==0) {
                wasPiecePlace=true;
                if (pieceType.equals("X")) board[row][col] = 1;
                if (pieceType.equals("O")) board[row][col] = 2;
            }else{
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
        }
        return wasPiecePlace;
    }

    public boolean isFull(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==0) return false;
            }
        }
        return true;
    }

    public int[][] getBoard(){
        return board;
    }
}
