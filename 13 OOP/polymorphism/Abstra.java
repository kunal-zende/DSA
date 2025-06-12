// package polymorphism;

public class Abstra {
    public static void main(String[] args) {
     Horse h = new Horse();
     h.walk();
    }
 }
 
 abstract class Animals{
     //non abstract function
     void eat(){
         System.out.println("Eats");
     }
     //abstract function
     abstract void walk();
 
     //constructor ->this will get called when the child class start execution
     //It is executed before child constructor get called
     Animals(){
         System.out.println("Animal Constructor get called");
     }
 }
 
 class Horse extends Animals{
    Horse(){
        System.out.println("Horse Constructor get called");
    }
     void walk(){
         System.out.println("Walk on four leg");
     }
 }