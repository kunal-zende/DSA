// package recursion 2;

public class RemoveDuplicate {
    public static void unique(String s, StringBuilder sb, int idx, boolean map[]){
        if(idx == s.length()){
            System.out.println(sb);
            return;
        }
        //Kaam
        if(map[s.charAt(idx) - 'a'] == true){
            unique(s, sb, idx+1, map);
        } else{
            map[s.charAt(idx)-'a'] = true;
            sb.append(s.charAt(idx));
            unique(s, sb, idx+1, map);
        }
    }
    public static void main(String[] args) {
        String s = "appnacollege";
        StringBuilder sb = new StringBuilder("");
        unique(s, new StringBuilder(""), 0,new boolean[26]);
    }
}
