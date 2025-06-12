public class Height{
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

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;  //base condition
        }
        int lh = heightOfTree(root.left); //calculate left height
        int rh = heightOfTree(root.right);//calculate right height
        return Math.max(lh,rh) + 1; //return to parent node
    }

    //Count of Node
    public static int nodeCount(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = nodeCount(root.left);
        int rightCount = nodeCount(root.right);
        return leftCount + rightCount + 1;
    }

    public static int sumOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfTree(root.left);
        int rightSum = sumOfTree(root.right);
        return leftSum + rightSum + root.data;
    }

    //Calculate diameter
    //approach 1
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int leftHeight = heightOfTree(root.left);
        int rightDiameter = diameter(root.right);
        int rightHeight = heightOfTree(root.right);
        int selfDia = leftHeight + rightHeight + 1; // selfDia = Diameter With Root
        return Math.max(selfDia , Math.max(leftDiameter,rightDiameter));
    }
    
    //Calculate diameter
    //approach 2
    public static class Info {
        int diameter;
        int height;
        public Info(int dia, int ht){
            this.diameter = dia;
            this.height = ht;
        }
    }

    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), rightInfo.height + leftInfo.height + 1);
        int ht = Math.max(leftInfo.height , rightInfo.height) + 1;

        return new Info(dia, ht);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        // System.out.println(heightOfTree(root));
        // System.out.println(nodeCount(root));
        // System.out.println(sumOfTree(root));
        // System.out.println(diameter(root));
        System.out.println(diameter2(root).diameter);
    }
}