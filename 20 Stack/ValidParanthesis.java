import java.util.*;

public class ValidParanthesis {
    public static boolean checkValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            } else{
                //if there exists closing without opening then it is false
                if(s.isEmpty()){
                    return false;
                }

                if((s.peek() == '(' && ch == ')') 
                || (s.peek() == '{' && ch == '}') 
                || (s.peek() == '[' && ch == ']')){
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')'){  //check closing code
                int count = 0;

                while(s.pop() != '('){
                    count++;
                }

                if(count < 1){
                    return true; //duplicate exists
                } 

            } else{  //opening bracket or other elements
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
        String str = "(a+b+(c+d))";
        // System.out.println(checkValid(str));
        System.out.println(isDuplicate(str));

    }
}
