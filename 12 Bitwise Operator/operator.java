public class operator{
    public static void main(String args[]){
        // System.out.println(5 & 6);
        // System.out.println(5 << 2);
        // checkeven(10);
        // checkeven(11);

        // System.out.println(getIthBit(8, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10,2 ,1));
        // System.out.println(clearLastIthBit(15, 2));
        // System.out.println(clearInRange(10,4,2));
        // System.out.println(powerOfTwo(4));
        // System.out.println(checkSetBit(10));
        // System.out.println(fastExpo(5, 3));
        System.out.println(28%26);
        System.out.println('B'-'A');
    }
    public static void checkeven(int n){
        if((n & 1) == 1){
            System.out.println("Odd number");
        } else {
            System.out.println("Even number");
        }
    }
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int n, int i){
        int bitmask = 1<<i;
        return (n | bitmask);
    }

    public static int clearIthBit(int n, int i){
        int bitmask = ~(1<<i);
        return (n & bitmask);
    }

    public static int updateIthBit(int num, int position, int bit){
        int bitmask = bit<<position;
        num = clearIthBit(num,position);
        return (num | bitmask);
    }

    // clear last bit from index i
    public static int clearLastIthBit(int n, int i){
        int bitMask = (~0)<<i;  //~0 = all 1's
        return (n & bitMask);
    }

    //Clear in range from i to j in reverse direction
    public static int clearInRange(int num, int j, int i){
        int a = ((~0) << (j+1)); // if j is 7 then this will make last 7 zero and other 1
        int b = (1<<i) -1;   // this will keep items from i position to last as 1 and other all zero
        int bitMask = a | b;
        return (num & bitMask);  // this will make range clear
    }

    //check num is in power of two
    public static boolean powerOfTwo(int num) {
            return (num & (num-1))==0;
        
    }

    public static int checkSetBit(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1){
                count++;   
            }
            num = num >> 1;
        }
        return count;
    }

    //Fast expontiational
    public static int fastExpo(int a,int n){   // 10^5 -> a=10 , n = 5
        int ans=1; 
        while(n > 0){
            if((n & 1) != 0){
            ans = ans *a; 
        }
            a = a*a;
            n = (n >> 1);
        }
        return ans;
    }
}