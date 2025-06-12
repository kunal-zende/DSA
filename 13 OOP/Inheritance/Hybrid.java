public class Hybrid{
    public static void main(String[] args) {
        Fish f1 = new Fish();
        f1.eat();
        f1.breath();

        nonMammel n1 = new nonMammel();
        n1.breath();
    }
}

class Animal{
    void breath(){
        System.out.println("Breath");
    }
}

class mammel extends Animal{
    void eat(){
        System.out.println("Eat");
    }
}

class Fish extends mammel{
    void swim(){
        System.out.println("Swim");
    }
}

class nonMammel extends Animal{
    void drink(){
        System.out.println("Drink");
    }
}