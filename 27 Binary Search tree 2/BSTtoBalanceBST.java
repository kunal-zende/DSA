import java.util.*;

public class BSTtoBalanceBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Convert from BST to Balanced BST (BST with minimum height)
    public static Node createBalanceBST(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // add inorder in array list
        getInorder(root, arrayList);

        // Create Balanced BST from sorted sequence
        root = BalanceBST(arrayList, 0, arrayList.size() - 1);
        return root;
    }

    // get inorder sequence
    public static void getInorder(Node root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arrayList);
        arrayList.add(root.data);
        getInorder(root.right, arrayList);
    }

    // Get the balanced BST
    public static Node BalanceBST(ArrayList<Integer> arrayList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arrayList.get(mid));
        root.left = BalanceBST(arrayList, start, mid - 1);
        root.right = BalanceBST(arrayList, mid + 1, end);
        return root;
    }
 //Preorder traversing
 public static void preorder(Node root){
    if(root == null){
        return;
    }

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
}
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
       
       
        root = createBalanceBST(root);
        preorder(root);

    }
}
