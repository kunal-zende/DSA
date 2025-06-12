

public class Subtree {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isRootMatches(Node root, Node subroot){
        if(root == null){
            return false; //no root match found
        }
        if(root.data == subroot.data){
            //as the root value matchs check for child nodes also matchs
            if(isChildMatches(root, subroot)){
                return true;
            }
        }
        //if root node not matches then check in left or right side of main tree matches
        return isRootMatches(root.left, subroot) || isRootMatches(root.right, subroot);
    }

    public static boolean isChildMatches(Node root, Node subroot){
        if(root == null && subroot == null){
            return true;
        }
        else if(root == null || subroot == null || root.data != subroot.data){
            return false;
        }
        //check if left side not matches
        if(!isChildMatches(root.left, subroot.left)){
            return false;
        }
        //check if right side not matches
        if(!isChildMatches(root.right, subroot.right)){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        Node subNode = new Node(2);
        subNode.left = new Node(4);
        subNode.right = new Node(5);

        System.out.println(isRootMatches(root, subNode));
    }
}
