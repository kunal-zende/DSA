public class sudoku {
    public static boolean isSafe(int sudo[][],int row, int col, int digit){
        //check in column 
        for(int i=0; i <= 8; i++){
            if(sudo[i][col] == digit){
                return false;
            }
        }

        //check in row
        for(int j =0; j <=8 ; j++){
            if(sudo[row][j] == digit) {
                return false;
            }
        }

        //Check that it is only one in that grid
        int startingRow = (row/3) * 3;
        int startingCol = (col/3) * 3;
        //3x3 grid
        for(int i = startingRow; i < startingRow+3; i++){
            for(int j = startingCol; j < startingCol+3; j++){
                if(sudo[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudo[][],int row,int col){
        //base case
        if(row == 9){
            return true;
        }

        //recursion 

        int nextRow = row;
        int nextCol = col + 1;
        //when all column from row finished and we need to move
        //on next row
        if(col + 1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudo[row][col] != 0 ){ //when there is non-empty place then move forward
            return sudokuSolver(sudo, nextRow, nextCol);
        }
        for(int digit=1; digit <= 9; digit++){
            if(isSafe(sudo, row, col, digit)){
                sudo[row][col] = digit;
                if(sudokuSolver(sudo, row, col)){ //solution exists
                    return true;
                }
                sudo[row][col] = 0;  //if we can't put value then place 0
            }
        }
        return false;
    }

    //Simple print Function
    public static void printSudoku(int sudo[][]){
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudo[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudo[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
    };

    if(sudokuSolver(sudo,0,0)){
        System.out.println("Solution exists");
        printSudoku(sudo);
    } else{
        System.out.println("Solution not exists");
    }
    }
}
