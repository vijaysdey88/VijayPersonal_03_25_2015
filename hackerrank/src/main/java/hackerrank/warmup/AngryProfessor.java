package hackerrank.warmup;

public class AngryProfessor {

	public static void main(String[] args) {
		 int[] times = {0, 0, 0, 0};
         int K = 2;
         
         String classCancelled = "YES";
         int studentsOnTime = 0;
         for(int j = 0; j < times.length; j++) {
             if(times[j] <= 0){
                 studentsOnTime++;
             }
             if(studentsOnTime >= K) {
                 classCancelled = "NO";
                 break;
             }
         }

         
         System.out.println(classCancelled);
	}

}
