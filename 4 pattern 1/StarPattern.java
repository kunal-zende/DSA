public class StarPattern{
    public static void main(String args[]){
        
        //Star pattern
        // for(int i = 1; i <=4 ; i++){
        //     for(int j = 1; j<=i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //inverted Star patter
        // for(int i = 5; i>0; i--){
        //     for(int j= 1; j <=i; j++){
        //         System.out.print("*");
        //     }System.out.println();
        // }

        //half pyramid pattern
        // for(int i =1; i<=4; i++){
        //     for(int j = 1; j<=i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        // char ch = 'A';
        // for(int i = 1; i<= 4; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.println();
        diamond(5);
        }
    
    public static void diamond(int num){
        for(int line = 1; line<= num; line++){
            for(int col = 1; col <= num-line; col++){
                System.out.print(" ");
            }
            for(int col = 1;col <= 2*line - 1; col++){
                System.out.print("*");
            }
            System.out.println();
    }
}}