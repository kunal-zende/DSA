public class BTtoBST{

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Information class to store information
    static class Info{
        boolean isValid;
        int size;
        int min;
        int max;

        public Info(boolean isValid,int size, int min, int max){
            this.isValid = isValid;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    //Static variable to track biggest bst
    public static int maxNodeBST = 0;

    //function to calculate largest BST
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);//null is
        }                                   //always valid BST

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        //Condition for in-valid
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }  

        //If any one from right or left subtree are in-valid then it is Invalid 
        // for that node
        if(leftInfo.isValid && rightInfo.isValid){
            maxNodeBST = Math.max(maxNodeBST,size);
            return new Info(true,size,min,max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String args[]){
    Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node(5);
    root.left.right = new Node(20);

    root.right = new Node(60);
    root.right.left = new Node(45);
    root.right.right = new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right = new Node(80);

    Info info = largestBST(root);
    System.out.println("Maximum size of nodes " + maxNodeBST);
}
}