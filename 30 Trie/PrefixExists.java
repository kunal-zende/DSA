public class PrefixExists {
    static class Node{
        Node child[] = new Node[26];
        boolean endOfWord = false;

        public Node(){
            for(int i = 0; i < child.length; i++){
                child[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.endOfWord = true;
    }
    
    // functionn to find prefix exists or not
    public static boolean startWith(String prefix){
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.child[idx] == null){
                return false; // character not exists
            }
            curr = curr.child[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String arr[] = {"man","mango", "apple", "app"};

        for(int i = 0; i< arr.length; i++){
            insert(arr[i]);
        }

        System.out.println(startWith("man"));
        System.out.println(startWith("moon"));
    }
}
