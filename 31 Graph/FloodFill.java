import java.util.*;

public class FloodFill {

    public void helper(int image[][],int row,int col,int color,boolean visited[][],int orignalCol){
        if(row == 0 || col == 0 || row >= image.length || col >= image[0].length 
        || visited[row][col] || image[row][col] != orignalCol){
            return;
        }

        image[row][col] = color;
        visited[row][col] = true;//added by me

        //left 
        helper(image, row-1, col, color, visited, orignalCol);

        //rigth
        helper(image, row+1, col, color, visited, orignalCol);

        //up
        helper(image, row, col+1, color, visited, orignalCol);

        //down
        helper(image, row, col-1, color, visited, orignalCol);
    }
    public int[][] floodfill(int image[][], int row, int col, int color){
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image,row, col, color,visited, image[row][col]);
        return image;
    }
    public static void main(String[] args) {
        
    }
    
}
