package games.ttt;

public class gameResolver {
    public static boolean are3PiecesInLine(int[][] board, int row, int col) {
        int gamePiece = board[row][col];
        if(gamePiece == 0) return false;

        //down direction
        boolean isCellOutOfBoard = (row + 1 > board.length - 1 || row + 2 > board.length - 1);
        if ( !isCellOutOfBoard && (board[row+1][col] == gamePiece) && (board[row+2][col] == gamePiece)){
            return true;
        }
        //up direction
        isCellOutOfBoard = (row - 1 < 0);
        if ( !isCellOutOfBoard && (board[row-1][col] == gamePiece) && (board[row-2][col] == gamePiece)){
            if ( !isCellOutOfBoard && (board[row-2][col] == gamePiece)) {
                return true;
            }
        }
        //right up direction
        isCellOutOfBoard = (row - 1 < 0) || (col+1 > board.length-1);
        if ( !isCellOutOfBoard && (board[row-1][col+1] == gamePiece)){
            isCellOutOfBoard = (row - 2 < 0) || (col+2 > board[0].length-1);
            if ( !isCellOutOfBoard && (board[row-2][col+2] == gamePiece)) {
                return true;
            }
        }
        //right direction
        isCellOutOfBoard = (col+1>board[0].length-1);
        if ( !isCellOutOfBoard && (board[row][col+1] == gamePiece)){
            isCellOutOfBoard = (col+2>board[0].length-1);
            if ( !isCellOutOfBoard && (board[row][col+2] == gamePiece)) {
                return true;
            }
        }
        //right down direction
        isCellOutOfBoard = (row+1>board.length-1) || (col+1>board[0].length-1);
        if ( !isCellOutOfBoard && (board[row+1][col+1] == gamePiece)){
            isCellOutOfBoard = (row+2>board.length-1) || (col+2>board[0].length-1);
            if ( !isCellOutOfBoard && (board[row+2][col+2] == gamePiece)) {
                return true;
            }
        }
        //left down direction
        isCellOutOfBoard = (row+1>board.length-1) || (col-1<0);
        if ( !isCellOutOfBoard && (board[row+1][col] == gamePiece)){
            isCellOutOfBoard = (row+2>board.length-1) || (col-2<0);
            if ( !isCellOutOfBoard && (board[row+2][col-2] == gamePiece)) {
                return true;
            }
        }
        //left direction
        isCellOutOfBoard = (col-1<0);
        if ( !isCellOutOfBoard && (board[row][col-1] == gamePiece)){
            isCellOutOfBoard = (col-2<0);
            if ( !isCellOutOfBoard && (board[row][col-2] == gamePiece)) {
                return true;
            }
        }
        //left up direction
        isCellOutOfBoard = (row-1<0) || (col-1<0);
        if ( !isCellOutOfBoard && (board[row-1][col-1] == gamePiece)){
            isCellOutOfBoard = (row-2<0) || (col-2<0);
            if ( !isCellOutOfBoard && (board[row-2][col-2] == gamePiece)) {
                return true;
            }
        }
        return false;
    }

    public static GameState resolve(int[][] board) {
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                boolean threeConsecutiveCells = are3PiecesInLine(board, row, col);
                if (threeConsecutiveCells){
                    if(board[row][col] == 1) return GameState.X_WON;
                    else return GameState.O_WON;
                }
            }
        }

        return GameState.IN_PROGRESS;
    }

    public enum GameState{IN_PROGRESS, X_WON, O_WON}

}
