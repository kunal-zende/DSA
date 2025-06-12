public class assignment {
    public static void main(String args[]){
    // System.out.println(xpowerx(4));
    // swap(5, 6);

    int x=6;
    System.out.println(x+" + "+1+" is "+-~x);
    }

    public static int xpowerx(int x){
        int ans = 1;
        int a = x;
        while(x > 0){
            if((x & 1)==1){
                ans = a * ans;
            }
            a = (a*a);
            x= x>>1;
        }
        return ans;
    }

    //swap number without using third number
    public static void swap(int a, int b){
        System.out.println("Before swaping a = "+a + " and "+ "b = "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swaping "+ "a = "+ a + " b = "+b); 
    }
}
