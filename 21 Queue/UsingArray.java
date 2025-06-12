
public class UsingArray {
    public static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front = 0;

    Queue(int num){
        arr = new int[num];
        size = num;
        rear = -1;
    }

    public static boolean isEmpty(){
        return rear == -1;
    }

    public static void add(int data){ //O(1)
       if(rear == size - 1){
        System.out.println("Queue is full");
        return;
       }
       rear = rear+1;
       arr[rear] = data;
    }

    public static int remove(){  //O(n)
        if(isEmpty()){
            return -1;
        }
        int val = arr[0];
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i+1];
        }
        rear = rear -1;
        return val;
    }

    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[0];
    }
    }

    public static void main(String args[]){
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
