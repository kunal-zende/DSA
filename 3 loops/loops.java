import java.util.*;

public class loops {
    public static void main(String args[]){
       
    //    whie loop 
        // int counter = 0;
        // while(counter < 100) {
        //     System.out.println("Hello World");
        //     counter++;
        // };

        // int number = 1;
        // while(number <= 10){
        //     System.out.println(number++);
            
        // }

        // int initial = 1;
        // int num = 5;
        // int sum = 0;
        // while(initial <= num ){
            
        //     sum = sum + initial;
        //     initial++;
        //     System.out.println(sum);
        // }

        // for(int i =0; i<=5; i++){
        //     for(int j=0; j<= 5; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // int num = 1234;
       
        
        // int val = 0;

        // while(num > 0) {
        //     int reminder = num%10;
        //     val = val*10 + reminder;
        //     num = num / 10;
        // }
        // System.out.println(val);

        // do while loop 
    //     int counter = 0;
    //     do {
    //         System.out.println("Hello World");
    //         counter++;
    //     }while(counter < 100)

    // Scanner sc = new Scanner(System.in);

    // while(true){
    //     int number = sc.nextInt();
    //     if(number%10 == 0){
    //         break;
    //     }
    // }
        
    // do{
    //     System.out.println("Enter number");
    //     int n = sc.nextInt();
    //     if(n%10== 0){
    //         continue;
    //     }
    //     System.out.println(n);
    // }while(true);
        
        // while(true){
        //     int num = sc.nextInt();
        //     for(int i=2; i<=9; i++){
        //         while ( num == i) {
        //             continue;
        //         }

           //     }
        //     }
        // }

        //Prime number 
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n==2 ){
            System.out.println("Prime nummber");
        } else{
            boolean isPrime = true;

            for(int i = 2; i<= Math.sqrt(n); i++){
                if(n%i == 0){
                    isPrime = false;
                }      
        }
        if(isPrime == true){
            System.out.println("Prime");
        } else{
            System.out.println("Not prime");
        }
        }    
     
}
}