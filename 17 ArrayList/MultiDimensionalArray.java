import java.util.ArrayList;

public class MultiDimensionalArray {
    public static void main(String args[]){
        //Array List inside ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>(); 

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        mainList.add(list1);  //add list inside main array list

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        
        mainList.add(list2);

        //Print nested arraylist
        for(int i = 0; i < mainList.size(); i++){
            ArrayList<Integer> currentArrayList = mainList.get(i);
            for(int j = 0; j < currentArrayList.size(); j++){
                System.out.print(currentArrayList.get(j) + " ");
            }
            System.out.println();
        }
        
        //main list
        System.out.println(mainList);
    }
}
