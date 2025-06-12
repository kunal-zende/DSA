
public class StairCase {
    public static void main(String args[]) {
        int matrix[][] = { { 1, 22, 34 },
                { 12, 23, 35 },
                { 15, 25, 40 } };
        
        stairSearch(matrix, 35);
    }

    public static void stairSearch(int matrix[][], int key) {
        int col = matrix[0].length-1;
        int row = 0;

        while (row < matrix.length && col >= 0) {
            if (key == matrix[row][col]) {
                System.out.println("key at " + "(" + row + "," + col + ")");
                break;
            }
            else if (key < matrix[row][col]) {
                col--;
            } else if (key > matrix[row][col]) {
                row++;
            }
        }
    }
}
