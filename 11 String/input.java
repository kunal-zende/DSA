import java.util.*;

public class input{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        // System.out.println(name);
        // String fullname = sc.nextLine();
        // System.out.println(fullname);

        // String name = sc.nextLine();
        // System.out.println(name.length());

        //Concatenation
        String firstName = "Kunal";
        // String lastName = "Zende";

        // String fullName = firstName + " " + lastName;
        // System.out.println(fullName.charAt(1));
        // character(fullName);

        //palindrom
        Palindrom("noon");

    }

    public static void character(String str){
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i));
        }
    }

    //Palindrom
    public static boolean Palindrom(String str){
        int n = str.length();
        for(int i = 0; i < str.length()/2; i++){
           if( str.charAt(i) != str.charAt(n-1 - i)){
             System.out.println("String is not palindrom");
             return false;
           }
        }
        System.out.println("Palindrom");
        return true;
    }
}