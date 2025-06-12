public class ShortestUniquePrefix {
    static class Node {
    Node child[] = new Node[26];
    boolean endOfWord = false;
    int freq;

        public Node(){
            for(int i = 0; i < child.length; i++){
                child[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Node();
            } else{
                curr.child[idx].freq++;
            }

            curr = curr.child[idx];
        }
        curr.endOfWord = true;
    }

    //Search shortest prefix
    public static void findShortestPrefix(Node root, String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < root.child.length; i++){
        if(root.child[i] != null){
                findShortestPrefix(root.child[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String args[]){
        String arr[] = { "dog", "dove","duck","zebra"};
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }

        root.freq = -1;
        findShortestPrefix(root,"");
    }
}
