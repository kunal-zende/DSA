public class ArrayTOBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Create BST from given sorted array
    public static Node createBalancedBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]); // mid of array will be root node
        root.left = createBalancedBST(arr, start, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, end);

        return root;
    }

    // Preorder traversing
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createBalancedBST(arr, 0, arr.length - 1);
        preorder(root);
    }
}