import java.util.*;

public class FirstNonRepeating {
    public static void PrintNonRepeating(String str){
        //Queue and Array creation
        Queue<Character> q = new LinkedList<>();
        int arr[] = new int[26];

        //Iterate through string
        for(int i = 0; i < str.length(); i++){
            q.add(str.charAt(i));
            arr[str.charAt(i) - 'a']++; //increase  frequency by 1 

            while(!q.isEmpty() && arr[q.peek()-'a'] > 1){ //until q becomes empty and 
                q.remove();                            //the frequency is greater than 1
            }                                          // remove
            //case 1
            if(q.isEmpty()){
                System.out.println("-1");
            } else{ // case 2
                System.out.println(q.peek());
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        PrintNonRepeating(str);
    }
}
