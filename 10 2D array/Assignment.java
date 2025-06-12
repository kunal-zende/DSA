public class Assignment{
    public static void main(String args[]){
        int matrix[][] = {{1,2,7},
                           {6,7,8}};
        // System.out.println(countKey(matrix, 7));
        // secondRowSum(matrix);
        transpose(matrix);
    } 

    //Q1 count the particular item in 2D array
    public static int countKey(int matrix[][], int key){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(key == matrix[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    //Q2 print sum of second row
    public static void secondRowSum(int matrix[][]){
        int sum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                sum+= matrix[1][j];
        }
        System.out.println("Second Row Sum is : "+sum);
    }

    //Q3 transpose of matrix
    public static void transpose(int matrix[][]){
        int matrix2[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix2[j][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < matrix2.length; i++){
            for(int j = 0; j < matrix2[0].length; j++){
                System.out.print(matrix2[i][j]+" ");
            }
            System.out.println();
        }
    }
}