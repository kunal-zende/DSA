public class SuperKeyword {
    public static void main(String[] args) {
        Bear b = new Bear();
        System.out.println(b.color);
    }
}

class Animales {
    String color;
    Animales(){
        System.out.println("Animal Constructor called");
    }
}


class Bear extends Animales {
    Bear(){
        super.color = "black";
        System.out.println("Bear constructor is called");
    }
} 