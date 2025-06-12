
public class Overriding {
    public static void main(String args[]){
        Deer d1 = new Deer();
        d1.eat();
    }
}

class Animal{
    void eat(){
        System.out.println("Eat sometthing");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("Eat grass");
    }
}

