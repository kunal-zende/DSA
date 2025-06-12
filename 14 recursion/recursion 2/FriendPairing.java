// package recursion 2;

public class FriendPairing {
    public static int friends(int n){
        /* when we have one person he has only 1 choice, two people 
        can be arrange in two ways either both can remain single
        or both can combine */ 

        if(n == 1 || n == 2){ 
            return n;
        }  
        /*If from n person 1 wants to stay single then we have to 
        arrange remaining n-1 people*/
        int single = friends(n-1);

        //For pair
        /*If from n person 2 wants to combine then we have to 
        arrange remaining n-2 people  also the person who is making 
        choice to pair has n-1 people to choose*/ 
        int pair = (n-1)*friends(n-2);

        int total = single + pair;

        return total;
    }

    public static void main(String[] args) {
        System.out.println(friends(3));
    }
}
