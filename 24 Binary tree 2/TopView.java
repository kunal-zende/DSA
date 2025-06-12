import java.util.*;
import java.util.LinkedList;

public class TopView {
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

    //Information class to add information about node and its horizontal dist
    static class Info{
        Node node;
        int horizontalDist;

        public Info(Node node, int horizontalDist){
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    public static void topView(Node root){
        //leval traversing

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();  // store horizontal dist & it's Node

        int min = 0, max = 0;

        //bfs
        q.add(new Info(root,0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){ //end is reached
                    break;
                } else{
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.horizontalDist)){ //first time node occurring
                    map.put(curr.horizontalDist, curr.node);
                }
    
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.horizontalDist - 1));
                    min = Math.min(min, curr.horizontalDist -1);
                }
    
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.horizontalDist + 1));
                    max = Math.max(max, curr.horizontalDist + 1);
                }
            }
        }

        for(int i = min ; i <= max; i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
