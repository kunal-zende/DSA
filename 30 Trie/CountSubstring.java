public class CountSubstring {
    static class Node {
        Node child[] = new Node[26];
        boolean endOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null; // initialise child array's each element by null
            }
        }
    }

    public static Node root = new Node();

    // Insertion Code
    public static void insertion(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.endOfWord = true;
    }

    // Search
    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx]; // here we came on child node
        }
        return curr.endOfWord == true; // If word end then true is save there otherwise false
    }

    //unique substring count
    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.child[i] != null){
                count += countNode(root.child[i]); //recursive call for function
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String key = "ababa";

        //Insert suffix in tree
        for (int i = 0; i < key.length(); i++) {
            insertion(key.substring(i));
        }

        System.out.println(countNode(root));
    }
}