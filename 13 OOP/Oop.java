public class Oop {
    public static void main(String args[]){
  
        Pen p1 = new Pen();    //p1 is object of class Pen
        p1.colour = "Black";  // we can also set/change properties/attributes
        p1.setTip(4);  //we can call function
        // System.out.println(p1.colour);
        // System.out.println(p1.tip);

        Pencile p3 = new Pencile();
        // p3.setColor("blue");
        // System.out.println(p3.getColor());
        // System.out.println(p3.getPencileTip());

        Student s1 = new Student();
        s1.marks[0] = 70;
        s1.marks[1] = 80;
        s1.marks[2] = 80;

        Student s2 = new Student(s1); //Copy s1 entiery in S22

        s1.marks[1] = 100; //even if we copied in before line then also due 
        for(int i = 0; i < 3; i++){  // to reference the value in s2 marks will also change
            System.out.println(s2.marks[i]);
        }
    }
}

class Pen {  //Create class
    String colour;  //Attributes
    int tip; 
    void setColour(String newcolour){   //function
        colour = newcolour;
    }
    void setTip(int newTip){
        tip = newTip;
    }
}

//getter and setter

class Pencile{
    private int pencileTip = 5;
    private String color = "black";
    void setColor(String newColor){
        this.color = newColor;
   }
    int getPencileTip(){
   return  this.pencileTip;
   }

   void setPencileTip(int newTip){
        this.pencileTip = newTip;
   }

    String getColor(){
    return this.color;
   }
}

class Student{
    int marks[];

    Student(){
        marks = new int[3];
    }

    //shallow copy  
    // Student(Student s1) {
    //    marks = new int[3];
    //    this.marks = s1.marks;  //copy s1 marks 
    // }

    //deep copy , here s1 values are already copied in s2 so then after change in s1 will not affect s2 
    Student(Student s1){
        marks = new int[3];
        for(int i = 0 ; i < marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }

   }
