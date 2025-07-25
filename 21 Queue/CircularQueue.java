
public class CircularQueue {

    public static class CirQue{
       static int arr[];
       static int size;
       static int rear;
       static int front;

       CirQue(int n){
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
       }

       //Empty
       public static boolean isEmpty(){
        return rear == -1 && front == -1;
       }

       //Full 
       public static boolean isFull(){
        return (rear+1)%size == front; 
        }
       
        //Add element
       public static void add(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        //First element
        if(front == -1){
            front = 0;
        }
        rear = (rear+1)%size;
        arr[rear] = data;
       }

       //Remove element
       public static int remove(){
        if(isEmpty()){
            return -1;
        }
        int result = arr[front];

        //If only one element is remaining
        if(rear == front){
            rear = front = -1;
        } else {
            front = (front+1) % size;
        }
        return result;
       }

       //Taking first (peek)
       public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
       }
    }
    public static void main(String args[]){
        CirQue q = new CirQue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
