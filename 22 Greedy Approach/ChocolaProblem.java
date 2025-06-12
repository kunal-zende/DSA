import java.util.*;

public class ChocolaProblem {
    public static void main(String args[]){
        int n = 4, m = 6;  // 4 rowa 6 cols
        Integer costVer[] = {2,1,3,1,4}; // m-1 Vertical cut cost
        Integer costHor[] = {4,1,2}; //n-1 Horizontal cost

        //Sort in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; //iterate through costHor & costVer array
        int hp = 1; //initially horizontal piece is 1 of chocolate ie. entire chocolate
        int vp = 1; //initially horizontal piece is 1 of chocolate ie. entire chocolate
        int cost = 0;

        while(h < costHor.length && v < costVer.length){
            if(costHor[h] <= costVer[v]){ //do expensive cut first
                cost = cost + (hp * costVer[v]);
                vp++; // vertical cut will increase vertical pieces
                v++;
            } else{
                cost+= (vp * costHor[h]);
                hp++;
                h++;
            }
        }
        //Any horizontal cut remaining
        while(h < costHor.length){
            cost+= (vp * costHor[h]);
            h++;
        }
        //Any vertical cut remaining
        while(v < costVer.length){
            cost+= (hp * costVer[v]);
            v++;
        }

        System.out.println("total cost is " + cost);
    }
}
