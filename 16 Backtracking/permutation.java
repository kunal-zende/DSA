public class permutation{
    public static void perform(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //backtracking
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            perform(newStr,ans + ch); //backtracking
        }
    }
     public static void main(String args[]){
            String str = "abc";
            perform(str, "");
        }
}