import java.util.*;
public class assignment {
    public static void main(String args[]){
// Count how many times lowercase vowels occurred in a String entered by the
// user.
    Scanner sc = new Scanner(System.in);
    // String str = sc.nextLine();
    // int count = 0;
    // for(int i = 0; i < str.length(); i++){
    //     char ch = str.charAt(i);
    //     if(ch == 'a'|| ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u'){
    //         count++;
    //     }
    // }
    // System.out.println("Count is: "+ count);

    anagrams("race","care");

    }

       //Determine if 2 Strings are anagrams of each other
    //Consider race and care
    public static void anagrams(String str1,String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){
            //convert String into character array
            char str1char[] = str1.toCharArray();
            char str2char[] = str2.toCharArray();

            //sorting array
            Arrays.sort(str1char);
            Arrays.sort(str2char);

            //check arrays are equal
            boolean result = Arrays.equals(str1char, str2char);
            if(result){
                System.out.println("anagram");
            }else{
                System.out.println("Not anagram");
            }
        }else{
            System.out.println("Not anagram");
        }
    }

}
