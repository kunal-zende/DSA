public class grid {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(findgrid(0, 0, num, num));;
        
    }
    public static int findgrid(int n, int m, int row, int col){
        if(n == row-1 && m == col-1){ //for last cell
            return 1;
        } else if(n == row || m == col){ //boundary cross condition
            return 0;
        }
        int right = findgrid(n+1, m,row,col); //for right side move
        int down = findgrid(n, m+1,row,col); //for down side move
        return right + down;
    }
}
