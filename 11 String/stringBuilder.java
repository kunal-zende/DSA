public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch <= 'z'; ch++){
            sb.append(ch);
        }
        // System.out.println(sb);
        System.out.println(upperCase("i am kunal zende "));
    }

    //Convert to upperCase
    public static String upperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

