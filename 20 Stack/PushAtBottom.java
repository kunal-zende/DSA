import java.util.*;

public class PushAtBottom {

    //this is recurrsetion 
    public static void pushtatbottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushtatbottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        pushtatbottom(s,4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
