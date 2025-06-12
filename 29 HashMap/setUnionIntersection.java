import java.util.HashSet;

public class setUnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> unionSet = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        for(int i : arr1){
            unionSet.add(i);
        }

        for(int i : arr2){
            unionSet.add(i);
        }

        //Intersection
        for(int i:arr1){
            intersectionSet.add(i);
        }

        int count = 0;

        for(int j=0 ; j < arr2.length; j++){
            if(intersectionSet.contains(arr2[j])){
                count++;
                intersectionSet.remove(arr2[j]);
            }
        }

        System.out.println("Union size "+ unionSet.size());
        System.out.println("Intersection size "+ count);

    }
}
