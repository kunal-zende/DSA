import java.util.*;

public class function{

    // public static void printHello(){
    //     System.out.println("Hello world");
    //     return;
    // }

    // public static int sumCalculator(int num1, int num2){
    //     int sum = num1 + num2;
    //     return sum;
    // }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
    }

    //product
    public static int product(int a, int b){
        int product = a*b;
        return product;
    } 

    //factorial
    public static int factorial(int a){
        int fact = 1;
        for(int num = a; num> 0; num--){
            fact*= num; 
        }
        return fact;
    }

    //binomial coefficient
    public static void coefficient(int a, int b){
        int aFact = factorial(a);
        int bFact = factorial(b);
        int aSubb = (a - b);
        int aSubbFact = factorial(aSubb);
        double coefficient = aFact/(bFact *aSubbFact);
        System.out.println(coefficient);
    }

    // //function overloading
    // public static int sum(int a, int b){
    //     return a+b;
    // }

    // public static int sum(int a, int b, int c){
    //     return a+b+c;
    // }

    // //function overloading using datatypes
    public static int sum(int a, int b){
        return a+b;
    }

    public static float sum(float a, float b){
        return a+b;
    }

    //prime number
    // public static boolean isPrime(int a){
    //     boolean prime = true;
    //     if( a == 2){
    //         prime = true;
    //    } else {
    //     for(int i =2; i< a; i++){
    //         if( a % i == 0) {
    //             prime = false;
    //             break;
    //         }
    //     }
    //    }
    //    return prime;
    // }

    //optimize way for prime number
    public static boolean isPrime(int a){
        boolean prime = true;
        if( a == 2){
            prime = true;
       } else {
        for(int i =2; i<= Math.sqrt(a); i++){
            if( a % i == 0) {
                prime = false;
                break;
            }
        }
       }
       return prime;
    }

    //All prime numbers in range
    public static void primeRange(int a){
       for(int i = 2; i<=a; i++){
        if(isPrime(i) == true){
            System.out.println(i);
        }
       }
    }
    
    //Binary to decimal
    public static void binToDec(int num){
        int pow = 0;
        int dec = 0;
        while(num > 0){
            dec = dec + (num % 10) * (int)Math.pow(2, pow);
            num = num/10;
            pow++;
        }
        System.out.println(dec);
    }

    //decimal to binary
    public static void decTobin(int num){
        int powe = 0;
        int val = 0;
        while(num > 0){
            int remin = num % 2 ;
            val = val + remin*(int)Math.pow(10, powe);
            powe++;
            num = num/2;
        }
        System.out.println(val);
    }

    //Question Sheet
    public static int avg(int a, int b, int c){
        int average = (a + b + c)/3;
        return average;
    }

    public static boolean isEven(int n){
        if(n % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    //Palindrom (i.e. 121 )
    public static void isPalindrom(int num){
        int num1 = num;
        int val = 0;
        while(num >0){
            int remain = num % 10;
            val = val*10 + remain;
            num = num/10;
        }
        if( val == num1){
            System.out.println("Palindrom");
        }else{
            System.out.println("Not Palindrom");
        }
    }

    //Sum of didgits in integer
    public static void intSum(int num){
        int val= 0;
        while(num > 0){
            val = val + num%10;
            num = num/10;
        }
        System.out.println(val);
    }

    //sum of even and odd
    public static void evenAndOdd(int num){
        int even = 0;
        int odd = 0;
        while(num > 0){
            int lastDigit = num % 10;
            if(lastDigit % 2 == 0 ){
                even+= lastDigit;
            } else{
                odd+= lastDigit;
            } 
            num = num /10;  
        }
        System.out.println("even sum "+ even);
        System.out.println("odd sum "+ odd);
    }

    public static void main(String args[]){
        // printHello();
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b =sc.nextInt();

        // swap(a, b);
        // System.out.println("original a = "+ a);
        // System.out.println("original b = "+ b);

        // int sum = sumCalculator(a, b);
        // System.out.println(sum);

        // int val = product(a, b);
        // System.out.println(val);

        // System.out.println(factorial(a));

        // coefficient(a, b);

        // System.out.println(sum(5,4));
        // System.out.println(sum(5.3f, 5.2f));

        //    if (isPrime(2) == true){
        //     System.out.println("Prime");
        //    }else{
        //     System.out.println("Not Prime");
        //    }

        // primeRange(10);

        // System.out.println("Enter binary Number");
        // int num = sc.nextInt();
        // binToDec(num);

        // System.out.println("Enter number to convert into Binary");
        // int num = sc.nextInt();
        // decTobin(num);
        
        // System.out.println(avg(3,4,5));

        // System.out.println(isEven(5));

        // isPalindrom(123);

        // intSum(1234);

        // evenAndOdd(123);
    }
}