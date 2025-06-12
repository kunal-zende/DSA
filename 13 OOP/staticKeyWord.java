public class staticKeyWord {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Kunal";
        s1.SchoolName = "JSPM";
        s1.percentage(10, 020, 30);

        Student s2 = new Student();
        System.out.println(s2.SchoolName);
        s2.percentage(30, 040, 050);
    }
}

class Student{
    String name; 
    static void percentage(int maths, int science, int english){
        System.out.println((maths+science+english)/3);
    }
    static String SchoolName;  //Now for all student object the school will be same 
}