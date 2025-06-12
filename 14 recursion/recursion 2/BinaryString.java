// print all binary string of size N without consecutive once
public class BinaryString {
    //n is the size of string we want
    //lastIndexValue it may be 0 / 1
    public static void nonConsecutiveOne(int n, String s,int lastIndexValue){
        if(n == 0){
            System.out.println(s);
            return;
        }
        nonConsecutiveOne(n-1, s+"0", 0);
        if(lastIndexValue == 0){
            nonConsecutiveOne(n-1, s+"1", 1);
        }
    }
    public static void main(String[] args) {
        nonConsecutiveOne(3, "", 0);
    }
}
