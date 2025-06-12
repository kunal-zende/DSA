import java.util.ArrayList;

public class LowestCommonAncestorAP1 {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node lowestAncestor(Node root, int node1, int node2){
        ArrayList<Node> path1 = new ArrayList<>();  //to store node 1 path
        ArrayList<Node> path2 = new ArrayList<>();  //to store node 2 path

        getPath(root, node1, path1);  //function to get path from root to node 1 and store in path 1
        getPath(root, node2, path2);

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lowestANode = path1.get(i-1);
        return lowestANode;
    }

    public static boolean getPath(Node root, int nodeValue, ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == nodeValue){
            return true;
        }
        
        //If node equal to root then check in left and right side
        boolean foundLeft =  getPath(root.left, nodeValue, path);
        boolean foundRight = getPath(root.right, nodeValue, path);

        if(foundLeft || foundRight){
            return true;
        }

        //if node not found in left and right also then remove the parent node as
        // it won't be part of the path from root to required node

        path.remove(path.size() -1);  //as it will be last node

        return false; //it will help in evaluation of foundLeft and foundRight
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int node1 = 4;
        int node2 = 5;

        Node lca = lowestAncestor(root, node1, node2);
        System.out.println(lca.data);
    }
}
