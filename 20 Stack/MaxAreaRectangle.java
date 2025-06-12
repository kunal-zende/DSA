import java.util.*;

public class MaxAreaRectangle{

    public static void maximumArea(int arr[]){
        //find nearest smaller rigth nsr[] , nearest smaller left nsl[]
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        //next smallest right O(n)
        for(int i = arr.length-1; i >= 0; i--){
            
            while( !s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            } 
            if(s.isEmpty()){
                nsr[i] = arr.length;
            } else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smallest left
        s = new Stack<>(); //empty stack
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            } else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //calculate maximum area
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] -1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("The Maximumarea is : "+ maxArea);
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        maximumArea(arr);
    }
}