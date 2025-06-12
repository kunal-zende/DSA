import java.util.ArrayList;

public class StoreWater {

    //Brute force
    public static void waterStore(ArrayList<Integer> list){ //O(n^2)
        int maxWater = 0;
        int width = 0;
        int height = 0;
        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j < list.size(); j++){
                width  =  j - i;
                height = Math.min(list.get(i), list.get(j));
                if(maxWater < (width * height)){
                    maxWater = (width * height);
                }
            }
        }
        System.out.println("Maximum Water store : "+ maxWater);
    }

    // O(n)
    public static void twoPointer(ArrayList<Integer> list){
        int i = 0;
        int j = list.size() - 1;
        int maxWater = 0;
        int height = 0;
        int width = 0;
        while(i < j){
            width = j - i;
            height = Math.min(list.get(i),list.get(j));
            maxWater = Math.max(maxWater,  width * height);
            if(list.get(i) < list.get(j)){
                i++;
            } else{
                j--;
            }
        }
        System.out.println("Maximum Water : "+ maxWater);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        // waterStore(list);
        twoPointer(list);

    }
}
