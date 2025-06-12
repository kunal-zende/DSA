
 public class diagonalSum {
    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };     
        // digSum(matrix);   
        optimal(matrix);
    }

    public static void digSum(int matrix[][]){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                //primary diagonal
                if(i == j){
                    sum+= matrix[i][j];
                }
                //secondary diagonal

                else if( i + j == matrix.length-1 && i != j){
                    sum+= matrix[i][j];
                }
            }
        }
        System.out.println("sum is "+ sum);
    } 

    public static void optimal(int matrix[][]){
        int sum =0;
        for(int i = 0; i < matrix.length; i++){
            sum+= matrix[i][i];  //primary diagonal
        
            if(i != matrix.length-1-i){ //remove dublicate
            sum+= matrix[i][matrix.length-1-i]; //secondary diagonal 
            }
        }
        System.out.println(sum);
    }
}
