// import java.lang.invoke.ClassSpecializer.Factory;

public class first{
    public static void Recursion(int n){
        if(n == 1){
            System.out.print(1);
            return;
        } 
        System.out.print(n + " ");
        Recursion(n - 1);
    }

    public static void increasing(int n){
      if(n==1){
        System.out.print(n+" ");
        return;
      } 
      increasing(n-1);
      System.out.print(n+" ");
    }

    public static int Factorial(int n){
      if(n == 1){
        return 1;
      }
      return n*Factorial(n-1);
    }

    //Sum of first n natural numbers
    public static int SumOfNatural(int n){
      if(n==1){
        return 1;
      }
      int val =  SumOfNatural(n-1);
      int sum = n + val;
      return sum;
    }
    public static void main(String args[]){
        // Recursion(10);
        // increasing(5);
        // System.out.println(Factorial(5));
        System.out.println(SumOfNatural(5));
    }
}