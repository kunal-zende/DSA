public class compression{
    public static void main(String args[]){
        String str = "aaabbbcccd";
        System.out.println(compress(str));
    }

    //Compression 
    public static String compress(String str){
        int num = 1;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length()-1; i++){
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    num++;
                }
            }
            if(num > 1){
                sb.append(str.charAt(i));
                sb.append(num);
            }else{
                sb.append(str.charAt(i));
            }
            num = 0;
        }
        return sb.toString();
    }

    //using String
     
    public static String com(String str){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            Integer count = 1;
            while(i < str.length() && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr+= str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
}