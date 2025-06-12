import java.util.*;
import java.util.LinkedList;

public class PreorderBuil {
    //Node class creation
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

    //Binary class Node
    static class BinaryTree{
        static int idx = -1;

        public static Node createBinaryTree(int data[]){
            idx++;
            if(data[idx] == -1){
                return null;
            }
            Node newNode = new Node(data[idx]);
            newNode.left = createBinaryTree(data);
            newNode.right = createBinaryTree(data);
            return newNode;  //this will return rootnode
        }

        public static void preOrderTraversal(Node rootNode){
            if(rootNode == null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(rootNode.data + " ");
            preOrderTraversal(rootNode.left);
            preOrderTraversal(rootNode.right);
        }

        public static void inOrderTraversal(Node root){
            if(root == null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root){
            if(root == null){
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelTraversal(Node root){
            if(root == null){
                return;
            }

            //Create queue to add 
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();//new line
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null); //level ends
                    }
                } else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }

        }
    }


    public static void main(String args[]){
        int preOrder[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.createBinaryTree(preOrder);
        // System.out.println(root.data);
        // tree.preOrderTraversal(root);
        // tree.inOrderTraversal(root);
        // tree.postOrderTraversal(root);
        tree.levelTraversal(root);
    }
}
