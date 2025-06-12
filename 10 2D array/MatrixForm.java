import java.util.*;

public class MatrixForm {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int [3][3];  //3*3 matrix
        int n = matrix.length;  //rows of matrix
        int m = matrix[0].length;  // column of matrix

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j =0; j < m; j++){
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }

        search(matrix, 5);
        largest(matrix);
    }
    public static boolean search(int matrix[][], int val){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == val){ 
                    System.out.print("Found at "+ i +","+j);
                    return true;
                }
            }
        } 
        System.out.print("Not Found");
        return false;
    }

    public static void largest(int matrix[][]){
        int large = Integer.MIN_VALUE;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] > large){
                    large = matrix[i][j];
                }
            }
        }
        System.out.println("Largest is "+ large);
    }
}
