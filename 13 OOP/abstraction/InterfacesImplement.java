// package abstraction;

import java.net.Socket;

public class InterfacesImplement {
    public static void main(String args[]){
        //Multiple Inheritance
        Human h = new Human();
        h.milk();
        h.water();
    }
}

//Multiple inheritance

interface Milk {
    void milk();
}

interface Water {
    void water();
}

class Human implements Milk, Water{
    public void milk(){
        System.out.println("Drink Milk");
    }

    public void water(){
        System.out.println("Drink Water");
    }
}
