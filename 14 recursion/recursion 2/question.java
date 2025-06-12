public class question{
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        // findIndex(0, arr, key);

        // print(12345);
        System.out.println(('1'-'0'));
    }

    /*
     For a given integer array of size N. You have to find all the 
     occurrences(indices)of a given element(Key) and print them.
     Use a recursive function to solve this problem
     */
    public static void findIndex(int n, int arr[], int key){
        if( n == arr.length){
            return;
        }
        if(arr[n] == key){
            System.out.println(n);
        }
        findIndex(n+1, arr, key);
    }

    /*
     Sample Input: 1947
     Sample Output: “one nine four seven
     */

     static String dict[] = {"zero","one", "two","three","four","five","six","seven","eight","nine"};

     public static void print(int n){
        if(n == 0){
            return;
        }

        int lastdigit = n%10;
        print(n/10);
        System.out.print(dict[lastdigit]+" ");
     }
}