import java.util.*;

public class ActivitySelection{
    public static void main(String args[]){
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9}; //sorted end time
        
        ArrayList<Integer> ans = new ArrayList<>();

        //as endtime is sorted first is by default included
        // ans.add(0);  //first even will be added
        // int lastEndTime = end[0]; 
        // int maxActivity = 1;

        // for(int i = 1; i < end.length; i++){
        //     if(start[i] >= lastEndTime){
        //         ans.add(i);
        //         lastEndTime = end[i];
        //         maxActivity++;
        //     }
        // }

        // //print ans
        // System.out.println("Maximum activity : "+ maxActivity);
        // for(int i = 0; i < ans.size(); i++){
        //     System.out.print("A" + ans.get(i) +' ');
        // }
        

        //If end time array is not sorted
        //sorting
        int activities[][] = new int[start.length][3];  //3-col = idx, start, end time
        for(int i = 0; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


        ans.add(activities[0][0]);  //first even will be added
        int lastEndTime = activities[0][2]; 
        int maxActivity = 1;

        for(int i = 1; i < end.length; i++){
            if(activities[i][1] >= lastEndTime){
                ans.add(activities[i][0]);
                lastEndTime = activities[i][2];
                maxActivity++;
            }
        }

        //print ans
        System.out.println("Maximum activity : "+ maxActivity);
        for(int i = 0; i < ans.size(); i++){
            System.out.print("A" + ans.get(i) +' ');
        }
    }
}