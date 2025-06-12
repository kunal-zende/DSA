import java.util.*;

public class IndianCoin{
    public static void main(String args[]){
        Integer coins[] = {1,2,5, 10, 20, 50, 100, 500, 2000}; //Integer bcz to use sort
        int amount = 121;

        //Sort array in descending array
        Arrays.sort(coins, Comparator.reverseOrder());

        int NotesCount = 0;

        ArrayList<Integer> coinsUsed = new ArrayList<>(); //to store all coins used

        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){ //while loop - check whether we can used
                    amount = amount - coins[i]; //same value note eg. two 500 for 1000
                    coinsUsed.add(coins[i]);
                    NotesCount++; 
                }
            }
        }

        System.out.println("Total Number of Notes "+ NotesCount);

        for(int i = 0; i < coinsUsed.size(); i++){
            System.out.print(coinsUsed.get(i) + " ");
        }
    }
}