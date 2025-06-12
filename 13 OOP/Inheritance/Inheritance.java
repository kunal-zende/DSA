package Inheritance;
class Inheritance {
    public static void main(String args[]){
        // Dog d1 = new Dog();
        // d1.eat();
        // d1.bark();

        //Multilevel Inheritance
        // Male m1 = new Male();
        //     m1.breath();
        //     m1.leg = 4;
        //     m1.boy();
        //     System.out.println(m1.leg);

        //Hierarchical Inheritance
        State1 s1 =  new State1();
        s1.country();

        state2 s2 = new state2();
        s2.country();
    }
}

class Animals{
    void eat(){
        System.out.println("eat");
    }

    String drink() {
        return "Drink water";
    }
}

class Dog extends Animals{
    void bark(){
        System.out.println("Dog Barks");
    }
}

//multilevel inheritance
class Mammel{
    void breath(){
        System.out.println("Breath");
    }
}

class Human extends Mammel{
    int leg;
}

class Male extends Human{
    void boy(){
        System.out.println("I'm boy");
    }
}

//Hierarchical Inheritace
class Nation{
    void country(){
        System.out.println("India");
    }
}

class State1 extends Nation{
    void state(){
        System.out.println("Maharashtra");
    }
}

class state2 extends Nation{
    void s(){
        System.out.println("Haryana");
    }
}