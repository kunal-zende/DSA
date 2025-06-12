
public class ShortestPath {
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        // System.out.println(shortPath(str));

        // .equals  
        String s1 = "Kunal";
        String s2 = "Kunal";
        String s3 = new String("Kunal");
        //here s1 = s2 but != s3
        // if(s1.equals(s3)){
        //     System.out.println("Equal string");
        // } else{
        //     System.out.println("Not equals");
        // }

        //substring
        String str1 = "Helloworld";
        // substring(str1, 0, 5);
        System.out.println(str1.substring(0,5));

    }

    public static String substring(String str, int start, int end) {
        String sub = "";
        for(int i = start ; i < end; i++){
            sub+= str.charAt(i);
        }
        System.out.println(sub);
        return sub;
    }

    public static float shortPath(String str){
        int x = 0, y = 0;
        for(int i = 0; i< str.length(); i++){
            char dir = str.charAt(i);   
            if(dir == 'N'){
                y++;
            } else if ( dir == 'S'){
                y--;
            }
            else if (dir == 'E'){
                x++;
            }else{
                x--;
            }
        }
        float val = (float)Math.sqrt(x*x + y*y); 
        return val;
    }


}
