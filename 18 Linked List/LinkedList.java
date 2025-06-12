public class LinkedList{
    //Node class
    public static class Node{
        int data;
        Node next;

        public Node(int data){  
            this.data = data;  //the upper data = this.data
            this.next = null; //for first we assign null
        }
    }

    public static Node head; // define head node
    public static Node tail; // define tail node
    public static int size;

    //Add to first
    public void addFirst(int data){
        size++;
        //Step 1 - Create new node
        Node newNode = new Node(data);
        //If linked list is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        //Step 2 - newnode next = refer to head node
        newNode.next = head;

        //Step 3 - head becomes the newnode
        head = newNode;
    }

    //Add to last
    public void addLast(int data){
        //Create new node
        Node newNode = new Node(data);
        size++;
        //if there is no node
        if(head == null){
            head = tail = newNode;
            return;
        }

        //point the previous tail node next to this node
        tail.next = newNode;
        
        //replace new node as tail node
        tail = newNode;
    }

    public void addMiddle(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i <idx-1){
            temp = temp.next; //here we add temp as previous node of index
            i++;
        }

        newNode.next = temp.next;  //new Node next assign further value
        temp.next = newNode;    //previous node add new Node
        
    }

    public void print(){
        Node temp = head;

        while(temp != null){
        //print current node
        System.out.print(temp.data + "->");
        //move to next node
        temp = temp.next;
        }
      System.out.println("null");
    }

    //Remove first
    public int removeFirst(){
        if(size == 0){
             //no node
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){ 
            //only  one node
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;  //the read becomes the node next to it
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail=null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Search
    //Iterative search
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            } 
            temp = temp.next;
            i++;
        }
        return -1; //Key not found
    }

    //Recursive function
    public int recSearch(int key){
        return helper(head,key);
    }
    //helper for recursivesearch
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        } 
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }   
        return idx+1;
        }
        
        //Reverse the Linked List
        public void revLinkedList(){
            Node prev = null;
            Node curr = head;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }

        //Remove nth node from back
        public void removeNthNodeFromBack(int n){
            //size cal
            int sz = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                sz++;
            }

            if(n == sz){  //first node -> as n calculated from back
                head = head.next;
                return;
            }

            //If deletion node is node head
            int  i = 1;
            Node prev = head;
            while( i < sz-n){  //sz-n = previous node
                prev = prev.next;
                i++;
            }

            prev.next = prev.next.next; //point previous next to directly next of deletion node
            return;
        }

        // Palindrome
        //Find Mid Node
        public Node midNode(Node head){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next; //+1
                fast = fast.next.next; //+2 
            }
            return slow;  //slow is mid
        }

        public boolean findPalindrome(){
            //step 1 find mid

            Node midNode = midNode(head);

            //step 2 - reverse from the mid
            Node prev = null;
            Node curr = midNode;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;
            Node left = head;

            //step 3 - check RHS = LHS
            if(head == null || head.next == null){
                return true;
            }
            while(right != null){
                if(right.data != left.data){
                    return false;
                }
                right = right.next;
                left = left.next;
            }
            return true;
        }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addMiddle(2, 9);
        // ll.print();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.print();
        // System.out.println(size);
        // ll.removeLast();
        // ll.print();
        // System.out.println(size);
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.recSearch(6));
        // System.out.println(ll.recSearch(3));
        // ll.revLinkedList();
        // ll.print();
        // ll.removeNthNodeFromBack(2);
        // ll.print();

        //Palindrom
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
      System.out.println(ll.findPalindrome());
    }
}