
public class UsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        // empty

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add element
        public static void add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove elements
        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            int result = head.data;
            //If only one element in remaining
            if(head == tail){
                head = tail = null;
            } else{
            head = head.next;
        }
        return result;
    }

    public static int peek(){
        if(isEmpty()){
            return -1;
        } 
        return head.data;
    }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
