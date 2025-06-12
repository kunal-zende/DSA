                                                                                                                                                                                                                                                                                                                                                                                                                                         public class constructor{
    public static void main(String args[]){
        Paint p1 = new Paint();
        Paint p2 = new Paint(12);
        Paint p3 = new Paint("Kunal");
    }
}

class Paint{
    int num;
    String name;
    // types of constructor 
    //non parameterized
    Paint(){
        System.out.println("Non parameterized Constructor");
    }       
    
    //Parameterized constructor
    Paint(int num){
        this.num = num;
        System.out.println(num);
    }

    Paint(String str){
        this.name = str;
        System.out.println(name);
    }
}