import java.util.ArrayList;
import java.util.Arrays;

public class MergeBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node mergeBST(Node roo1,Node roo2){
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        getInorder(roo1, arrayList1);
        getInorder(roo2,arrayList2);

        int i = 0, j = 0;
        ArrayList<Integer> sortedArrayList = new ArrayList<>();

        while(i < arrayList1.size() && j < arrayList2.size()){
            if(arrayList1.get(i) <= arrayList2.get(j)){
                sortedArrayList.add(arrayList1.get(i));
                i++;
            } else{
                sortedArrayList.add(arrayList2.get(j));
                j++;
            }
        }

        while(i < arrayList1.size()){
            sortedArrayList.add(arrayList1.get(i));
            i++;
        }
        while(j < arrayList2.size()){
            sortedArrayList.add(arrayList2.get(j));
            j++;
        }

       Node root = createBST(sortedArrayList,0,sortedArrayList.size()-1);
       return root;
    }
    // to get inorder
    public static void getInorder(Node root,ArrayList<Integer> arraylist){
        if(root == null){
            return;
        }
        getInorder(root.left, arraylist);
        arraylist.add(root.data);
        getInorder(root.right, arraylist);
    }
    //create bst from sorted array
    public static Node createBST(ArrayList<Integer> arr, int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1,end);
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
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        System.out.println(root.data);
        preorder(root);
    }
}
