public class TilingProblem {
    public static int tiling(int n){ //n is for 2*n
        if(n == 0 || n ==1){ //for 0 we will not place any tile 
            return 1;   //so that will be also 1 way to not place any tile
        }
        //Vertical tiling
        int fnm1 = tiling(n-1);

        //horizontal tiling
        int fnm2 = tiling(n-2);

        //total ways
        int total = fnm1 + fnm2;

        return total;
    }

    public static void main(String args[]){
        System.out.println(tiling(3));
    }
}
