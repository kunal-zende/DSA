
public class LowestAncestorAP2 {
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
        if(root == null || root.data == node1 || root.data == node2){
            return root;  //root node 
        }

        Node FoundOnleftside = lowestAncestor(root.left, node1, node2);
        Node FoundOnRightside = lowestAncestor(root.right, node1, node2);

        //if found on left side and right side give null then ans exists in left side
        if(FoundOnRightside == null){
            return FoundOnleftside;
        } 

        //if found on right side and left side give null then ans exists in right side
        if(FoundOnleftside == null){
            return FoundOnRightside;
        } 

        //If we found on both right and left side one value then we return parent node
        //as it is the common ancestor

        return root;
    }

    //Find minimum distance bt two nodes
    public static int minimumDistance(Node root, int node1, int node2){
       Node lowestComAncestor = lowestAncestor(root, node1, node2); //We will get lowest common
        int dist1 = distFromAncestor(lowestComAncestor, node1);                                                             //ancestor
        int dist2 = distFromAncestor(lowestComAncestor, node2); 
        return dist1 + dist2;                                                            //ancestor
    }                                                          
    
    public static int distFromAncestor(Node root,int node){
        if(root == null){  //If no value found
            return -1;
        }

        if(root.data == node){
            return 0; //we will start measuring distance from this node
        }

        int distLeftside = distFromAncestor(root.left, node);
        int distRighttside = distFromAncestor(root.right, node);

        //If both give -1 then node not present in that sub tree
        if(distLeftside == -1 && distRighttside == -1){
            return -1;
        }
        //If we get val from left side and right gives -1 then node lies on left
        else if(distRighttside == -1){
            return distLeftside+1;
        } else if(distLeftside == -1){
            return distRighttside +1;
        }
        return -1;
    }

    //Find the Kth ancestor
    public static int KthAncestor(Node root, int node1, int k){
        if(root == null){
            return -1;
        }
        if(root.data == node1){  //we find the node
            return 0;
        }
        int leftSide = KthAncestor(root.left, node1, k);
        int rightSide = KthAncestor(root.right, node1, k);

        if(leftSide == -1 && rightSide == -1){ //Node not present in this subtree
            return -1; 
        }

        //If we receive some valid value rather than -1 from any of side the we check 
        //whether that node is the required ancestor or not

        int max = Math.max(leftSide,rightSide);

        if(max + 1 == k){  //this node is our required ancestor
            System.out.println(root.data);
        }
        return max + 1;
    }

    //Transform to sum tree
    public static int sumTree(Node root){
        if(root == null) {
            return 0;
        }

        int leftSubtree = sumTree(root.left);
        int rightSubtre = sumTree(root.right);

        int rootData = root.data;

        int newLeft = root.left == null ? 0 : root.left.data; 
        int newRight = root.right == null ? 0 : root.right.data; 
        root.data = leftSubtree + rightSubtre + newLeft +newRight;
        return rootData;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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
        int node2 = 6;

        // Node commonAncestor = lowestAncestor(root, node1, node2);
        // System.out.println(commonAncestor.data);

        // System.out.println(minimumDistance(root, node1, node2));

        // KthAncestor(root, node1, 2);

        sumTree(root);
        preOrder(root);
}
}