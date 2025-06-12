import java.util.*;

public class Implementation {
    static class HashMap<K, V> { // K,V both are generic so it can be string,int, boolean etc
        // Node class
        private class Node {
            K key; // key type K
            V value; // value type V

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n store size of nodes
        private int N;
        private LinkedList<Node> bucket[]; // array of linked list, its size = N

        @SuppressWarnings("unchecked") // this is to avoid warning of not allocating data type and keep code running
        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4]; // @SuppressWarnings("unchecked") is used for this line
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>(); // create linked list at each index of array
            }
        }

        // Hashing
        private int hashFunction(K key) {
            int hc = key.hashCode(); // take hashcode for the key
            return Math.abs(hc) % N; // we want the index that lies in our array
        }

        // Get node index in linked list
        private int SearchInLL(K key, int bucketIdx) { // check whether node of same value exists
            LinkedList<Node> ll = bucket[bucketIdx];
            int nodeIdx = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return nodeIdx;
                }
                nodeIdx++;
            }
            return -1;
        }

        // Rehash to keep time complexity constant
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket; // store bucket data
            bucket = new LinkedList[2 * N];
            N = 2 * N;

            for (int i = 0; i < N; i++) {
                bucket[i] = new LinkedList<>(); // initialise linkedlist at each element
            }

            // Node -> add in bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIdx = hashFunction(key); // this will return bucket index
            int nodeIdx = SearchInLL(key, bucketIdx); // this will return linked list index present at array's bucketIdx

            if (nodeIdx != -1) { // node with same key already exists
                Node node = bucket[bucketIdx].get(nodeIdx); // take that particular node
                node.value = value; // update value
            } else { // Id=f node not exists
                bucket[bucketIdx].add(new Node(key, value));
                n++; // node size increased
            }

            double lambda = (double) n / N;
            if (lambda > 2) { // let 2 be constant thresh hold
                rehash();
            }
        }

        // get function
        public V get(K key) {
            int bucketIdx = hashFunction(key); // this will return bucket index
            int nodeIdx = SearchInLL(key, bucketIdx); // this will return linked list index present at array's bucketIdx

            if (nodeIdx != -1) { // node with same key already exists
                Node node = bucket[bucketIdx].get(nodeIdx); // take that particular node
                return node.value;
            } else { // Id=f node not exists
                return null;
            }
        }

        public boolean containsKey(K key) {
            int bucketIdx = hashFunction(key); // this will return bucket index
            int nodeIdx = SearchInLL(key, bucketIdx); // this will return linked list index present at array's bucketIdx

            if (nodeIdx != -1) { // node with same key already exists
                return true;
            } else { // Id=f node not exists
                return false;
            }
        }

        // Remove function
        public V remove(K key) {
            int bucketIdx = hashFunction(key); // this will return bucket index
            int nodeIdx = SearchInLL(key, bucketIdx); // this will return linked list index present at array's bucketIdx

            if (nodeIdx != -1) { // node with same key already exists
                Node node = bucket[bucketIdx].remove(nodeIdx);
                n--;
                return node.value; // return deleted node value
            } else { // Id=f node not exists
                return null;
            }
        }

        // key set
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> count = new HashMap<>();
        count.put("India", 100);
        count.put("USA", 50);
        count.put("Dubai", 79);

        ArrayList<String> keys = count.keySet();

        for (String k : keys) {
            System.out.println(k);
        }

        System.out.println(count.get("India"));
        System.out.println(count.remove("Dubai"));
        System.out.println(count.get("Dubai"));
    }
}