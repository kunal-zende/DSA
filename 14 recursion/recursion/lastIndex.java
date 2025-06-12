import java.util.ArrayList;

public class lastIndex {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,2};
        // System.out.println(lastIndex(arr, 2, 0));
        // System.out.println(power(2, 5));
        // System.out.println(optimizedPow(2, 05));

        ArrayList <Integer> list = new ArrayList<>();
        //Add elements at end
        list.add(8);
        list.add(4);

        System.out.println(list);

        //get element base on their index\
        list.get(0);
        System.out.println(list.get(1));

        /*add element in between
        this does not replace the element at that position instead it 
        add element at that position and shift that position and all element to next index*/
        list.add(1,2);  //index 1 value set 2
        System.out.println(list);

        // Replace/set element at particular index
        list.set(1,5);  //2 will replace by 5
        System.out.println(list);
        
        //Remove or delete element bbased on index
        list.remove(2);  //remove element at index 2
        System.out.println(list);

        //size of list
        list.size();
        System.out.println(list.size());
    }

    public static int  lastIndex(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        int last = lastIndex(arr, key, i+1);
        if(last == -1 && arr[i] == key){
            return i;
        }
        return last;
    }

    //Print x to power y
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int xnm1 =  power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }

    public static int optimizedPow(int x,int n){
        if(n==0){
            return 1;
        }
        int half = optimizedPow(x, n/2);
        int full = half * half;
        if(n%2 != 0){
            return x * full;
        }
        return full;
    }
}
