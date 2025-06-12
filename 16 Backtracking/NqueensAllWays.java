public class NqueensAllWays {

    public static boolean nQueen(char board[][],int row){
        
        if( row == board.length){
            // printBoard(board);
            count++;
            return true;
        }
        for(int j = 0; j < board.length; j++){
            if(isSafe(board,row, j)){
            board[row][j] = 'Q';
          if(nQueen(board, row+1)){
            return true;
            }
            board[row][j] = 'X'; //backtracking
        }
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertically up
            for(int i = row-1 ; i >= 0; i--){
                if(board[i][col] == 'Q'){
                    return false;
                }

            }
        //diagonally left
            for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
        //diagonally right
            for(int i = row-1, j = col+1; i>=0 && j<board.length; i--,j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
        return true;
    }

    public static void printBoard(char board[][]){
        System.out.println("-------chess board------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0; //to count total number of ways

    public static void main(String args[]){
        int n = 4;
        char board[][] = new char[n][n];

         //initialize the board
         for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 'X';
            }
        }
        if(nQueen(board , 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        } else{
            System.out.println("Solution is not possible");
        }
        // System.out.println("Toyal count is "+count);
    }

}
