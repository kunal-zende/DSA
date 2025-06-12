public class LongestWordWithPrefix {
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

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i = 0; i < 26; i++){
            if(root.child[i] != null && root.child[i].endOfWord == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.child[i], temp);
                temp.deleteCharAt(temp.length()-1); //we remove last character 
            }
        }
    }

    public static void main(String[] args) {
        String word[] = {"a","app","appl","ap","apple","apply","banana"};
        for(int i = 0; i < word.length; i++){
            insertion(word[i]);
        }

        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }   
}
