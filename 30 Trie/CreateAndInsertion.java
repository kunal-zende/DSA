public class CreateAndInsertion {
    static class Node {
        Node child[] = new Node[26];
        boolean endOfWord = false;

        public Node(){
            for(int i =0 ; i < 26; i++){
                child[i] = null;
            }
        }
    }

    public static Node root = new Node();
    public static void main(String[] args) {
        
    }
}
