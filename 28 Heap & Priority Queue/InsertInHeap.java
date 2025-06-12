// import java.util.ArrayList;

// public class InsertInHeap {
//     static class Heap {
//         ArrayList<Integer> arr = new ArrayList<>();

//         public void add(int data) { // O(logn) due to while loop
//             arr.add(data);

//             int x = arr.size() - 1; // index of child ie. last added element
//             int parent = (x - 1) / 2; // index of parent

//             while (arr.get(x) < arr.get(parent)) { // O(logn)
//                 // swap
//                 int temp = arr.get(x);
//                 arr.set(x, arr.get(parent));
//                 arr.set(parent, temp);

//                 x = parent; //visualize in array 
//                 parent = (x-1)/2;
//             }
//         }

//         // peek function
//         public int peek(){ //it return minimum that is root node i.e. first value
//             return arr.get(0);
//         }

//         // Delete function
//         public int remove(){   // O(N)
//             //step-1 swap first with last indes
//             int temp = arr.get(0);
//             arr.set(0,arr.get(arr.size()-1));
//             arr.set(arr.size()-1,temp);

//             //step-2 remove last
//             arr.remove(arr.size()-1);

//             //step-3 call heapify to fix structure
//             heapify(0);
//             return temp; //temp is removed
//         }

//         //heapify function
//         private void heapify(int idx){
//             int i = idx;
//             int leftChild = 2*i + 1;
//             int rightChild = 2*i + 2;
//             int minIdx = i;

//             //check child exists and also minimum value from root,left,right
//             if(leftChild < arr.size() && arr.get(leftChild) < arr.get(minIdx)){
//                 minIdx = leftChild;
//             }
//             if(rightChild < arr.size() && arr.get(rightChild) < arr.get(minIdx)){
//                 minIdx = rightChild;
//             }

//           if(minIdx != i){
//               //Swap root with minimum value
//               int temp = arr.get(i);
//               arr.set(i,arr.get(minIdx));
//               arr.set(minIdx,temp);
//               heapify(minIdx); //fix entire tree order
//           }

//         }

//         //Is empty
//         public boolean isEmpty(){
//             return arr.size()==0;
//         }
//     }

//     public static void main(String[] args) {
//         Heap h = new Heap();
//         h.add(3);
//         h.add(1);
//         h.add(2);

//         while (!h.isEmpty()) {
//             System.out.println(h.peek());
//             h.remove();
//         }
//     }
// }

//---------------CODE FOR MAX HEAP---------------------------------//

import java.util.ArrayList;

public class InsertInHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn) due to while loop
            arr.add(data);

            int x = arr.size() - 1; // index of child ie. last added element
            int parent = (x - 1) / 2; // index of parent

            while (arr.get(x) > arr.get(parent)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent; //visualize in array 
                parent = (x-1)/2;
            }
        }

        // peek function
        public int peek(){ //it return minimum that is root node i.e. first value
            return arr.get(0);
        }

        // Delete function
        public int remove(){   // O(N)
            //step-1 swap first with last indes
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step-2 remove last
            arr.remove(arr.size()-1);

            //step-3 call heapify to fix structure
            heapify(0);
            return temp; //temp is removed
        }

        //heapify function
        private void heapify(int idx){
            int i = idx;
            int leftChild = 2*i + 1;
            int rightChild = 2*i + 2;
            int minIdx = i;

            //check child exists and also minimum value from root,left,right
            if(leftChild < arr.size() && arr.get(leftChild) > arr.get(minIdx)){
                minIdx = leftChild;
            }
            if(rightChild < arr.size() && arr.get(rightChild) > arr.get(minIdx)){
                minIdx = rightChild;
            }

          if(minIdx != i){
              //Swap root with minimum value
              int temp = arr.get(i);
              arr.set(i,arr.get(minIdx));
              arr.set(minIdx,temp);
              heapify(minIdx); //fix entire tree order
          }

        }

        //Is empty
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(1);
        h.add(2);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}