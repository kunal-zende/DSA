public class sub{
    public static void findSubset(String str,int i,String s){
        //Base case
        if(i == str.length()){
            if(s.length() == 0){
                System.out.println("null");
            } else {
                System.out.println(s);
            }
            return;
        }
       
        //recursion
        //yes element added
        findSubset(str,i+1,s+str.charAt(i));

        //Not elemente added
        findSubset(str, i+1, s);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, 0, "");
    }
}