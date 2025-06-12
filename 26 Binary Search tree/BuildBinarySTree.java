import java.util.*;

public class BuildBinarySTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node createBST(Node root, int val){
        if(root == null){
             root = new Node(val); //first condition where there is no tree
             return root;
        }

        //if inserting val is less then it goes on left side of root other wise right side
        if(root.data > val){
            root.left = createBST(root.left, val);
        } else {
            root.right = createBST(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Search in BST
    public static boolean searchBST(Node root, int val){
        if(root == null){
            return false;
        }

        if(root.data == val){
            return true;
        }

        if(root.data > val){//if val is smaller than root then it must lies in left side so
            return searchBST(root.left, val);//return from left side no need to search in right
        } else{
            return searchBST(root.right, val);
        }
    }

    //Delete node 
    public static Node delete(Node root, int val){
        //search the node we want to delete
        if(root.data > val){
            root.left = delete(root.left, val);
        } else if( root.data < val){
            root.right = delete(root.right, val);
        }
        else{ //If we found the node
            // case-1 leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case-2 One child node
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }

            //Case-3 two child nodes
            //replace node value we want to delete with inorder successor and then delete
            //Inorder successor
            Node IS = findInOrderSuccessor(root.right); //as inorder successor lies in right sub-tree
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    //function to find inorder successor
    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){  
            root = root.left;  //inorder successor is at left most leaf of right subtree
        }
        return root;
    }

    //Find in the Range
    public static void findInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            findInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            findInRange(root.right, k1, k2);
        } else if(root.data < k1){
            findInRange(root.left, k1, k2);
        } else{
            findInRange(root.right, k1, k2);
        }
    }

    //Root to leaf code
    public static void root2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }

        root2leaf(root.left, path);
        root2leaf(root.right, path);

        path.remove(path.size()-1);
    }

    //to print the path
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    //validate BST
    public static boolean validateBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){ //if node is less than the minimum 
            return false;
        } else if( max != null && root.data >= max.data){
            return false;
        }

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int val[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i = 0; i < val.length; i++){
           root = createBST(root, val[i]);
        }

        // inorder(root);
        // System.out.println();
        // if(searchBST(root, 4)){
        //     System.out.println("Found");
        // } else{
        //     System.out.println("Not Found");
        // }

        // root = delete(root, 3);
        // inorder(root);

        // findInRange(root, 2, 7);
        // ArrayList<Integer> path = new ArrayList<>();
        // root2leaf(root, path);

        if(validateBST(root, null, null)){
            System.out.println("Valid");
        } else{
            System.out.println("Invalid");
        }
    }
}
