public class DoublelinkedList{

    //Create new Node
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next  = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    //Add last
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //Print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove first
    public void removeFirst(){
        if(head == null){
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast(){
        if(tail == null){
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        Node temp = tail.prev;
        temp.next = null;
        tail.prev = null;
        tail = temp;
        size--;
    }

    //Reverse the node
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublelinkedList dll = new DoublelinkedList();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        // dll.print();
        // System.out.println(dll.size);
        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);
        // dll.print();
        // dll.removeLast();
        dll.print();
        // System.out.println(size);
        dll.reverse();
        dll.print();
    }
}