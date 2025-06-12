import java.util.*;

public class cond {
    public static void main(String args[]){
        // int A = 4;
        // if (A % 2 == 0){
        //     System.out.println("Even");
        // } else {
        //     System.out.println("Odd");
        // }
        Scanner sc = new Scanner(System.in);
  
        // if(Salary <= 5){
        //     System.out.println("No Tax");
        // } else if (Salary > 5 && Salary <= 10){
        //     System.out.println("20% tax : " +( Salary * 0.2));
        // } else {
        //     System.out.println("30% tax : " + Salary * 0.3);
        // }
       
        // int Salary =(int) sc.nextFloat();

        // String payable = (Salary > 5) ? "Tax payable": "Tax free";
        // System.out.println(payable);

        // switch(Salary) {
        //     case 1 : System.out.println("Salary is 1 lakh");
        //     break;
        //     case 2 : System.out.println("2 lakh");
        //     break;
        //     default : System.out.println("unemployed"); 
        // }
        System.out.print("Enter a");
        int a = sc.nextInt();
        System.out.print("Enter b");
        int b = sc.nextInt();
        System.out.println("Enter Operator");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+': System.out.println(a+b); 
                break;
            case '-' : System.out.println(a-b);
                break;
            case '*' : System.out.println(a*b);
                break;
            default: System.out.println("Wrong Operator");
                break;
        }
    }
}
