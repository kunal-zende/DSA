
public class overloading {
    public static void main( String args[]){
        Calculator c1 = new Calculator();
        System.out.println(c1.sum(10,12));
        System.out.println(c1.sum(2,4,7));
        System.out.println(c1.sum((float)1.234,(float)2.456));
    }
}

class Calculator{
    int sum(int a, int b){
        return a+b;
    }

    int sum(int a, int b, int  c){
        return a+b+c;
    }
    
    float sum(float a, float b){
        return a+b;
    }
}