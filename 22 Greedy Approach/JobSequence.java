import java.util.*;

public class JobSequence {
    //creare job class
    static class Job{
        int index; //0(A), 1(B)
        int deadline;
        int profit;

        public Job(int idx, int d, int p){
            index = idx;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String args[]){
        int jobInfo[][] = {{4,20},{1,10}, {1,40}, {1,30}};

      ArrayList<Job> jobs = new ArrayList<>();
      
      //create Job object and store in jobs ArrayList which store Job object
      for(int i = 0; i < jobInfo.length; i++){
        jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
      }
      
      //Sort Job object in descending order based on profit 
      Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit); //descending

      int time = 0; //time taken by jobs

      ArrayList<Integer> seq = new ArrayList<>();//to store index of 
                                                 //job that can be performed

      for(int i = 0; i < jobs.size(); i++){
        Job curr = jobs.get(i);
        if(curr.deadline > time){ //if deadline is far than the time required to complete
            seq.add(curr.index);
            time++; //each job takes unit time to complete
        }
      }

      System.out.println("Maximum jobs can prform "+ seq.size());
      for(int i = 0; i < seq.size(); i++){
        System.out.print(seq.get(i) + " ");
      }
    }
}
