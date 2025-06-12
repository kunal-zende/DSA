import java.net.Socket;

public class loopFinding {
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        //if list is not empty
        newNode.next = head;
        //Step 3 - head becomes the newnode
        head = newNode;
    }

    public static void addlast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    //Loop finding
    public boolean findCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  //at some node they meet so there must be loop
                return true; //cycle exists
            }
        }
        return false; //cycle doesn't exists
    }

    //Remove cycle
    public void removeCycle(){

            Node slow = head;
            Node fast = head;
            Node last = null;

            boolean isCycle = false;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                  isCycle = true;
                  break;
                }
            }

            //Find last node
            if(isCycle == false){
                System.out.println("Not loop");
                return;
            } 

            slow = head;
            while(slow != fast){
                last = fast;
                slow = slow.next;  //+1
                fast = fast.next;  //+1
            }
        //last  node point to null
        last.next = null;
    }

    //Merge sort
    public Node mergeSort(Node head){
        //base condition
        if(head == null || head.next == null){
            return head;
        }
        //step 1 : find mid
        Node midNode = getMidNode(head);

        //step 2 : separate left side and right side
        Node rightHead = midNode.next;
        midNode.next  = null;

        //step 3 : merge sort recursition
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //step 4 : merge 
        return merge(newLeft, newRight);
    }

    //Get mid node for merge
    private Node getMidNode(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //merging code
    private Node merge(Node newLeft, Node newRight){
        Node mergeList = new Node(-1); 
        Node temp = mergeList;
        while(newLeft != null && newRight != null){
            if(newLeft.data < newRight.data){
                temp.next = newLeft;
                newLeft = newLeft.next;
                temp = temp.next;
            } else{
                temp.next = newRight;
                newRight = newRight.next;
                temp = temp.next;
            }
        }
        while(newLeft != null){
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }

        while(newRight != null){
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }
        return mergeList.next;
    }

    //Zig-Zag linked list
    public void zigzag(){
        //step-1: find mind 
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //step-2: Reverse from mid 
        Node curr = mid.next;
        mid.next = null;  // break into to half
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //step 3: zig-zag the node
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    } 
    public static void main(String args[]){
        loopFinding ll = new loopFinding();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.print();

        ll.zigzag();
        ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();
        // ll.addlast(2);
        // ll.print();
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // temp.next = new Node(3);
        // temp.next.next = new Node(4);
        // temp.next.next.next = temp;
        // System.out.println(ll.findCycle());
        // ll.removeCycle();
        // System.out.println(ll.findCycle());

        }
}
