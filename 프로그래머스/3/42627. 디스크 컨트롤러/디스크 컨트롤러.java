import java.util.*;

class Solution {
    int resTime = 0;
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        processing(jobs);
        
        return resTime;
    }
    
    private void processing(int[][] jobs){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        boolean[] visited = new boolean[jobs.length];
        int time = 0;
        for(int i = 0; i < jobs.length; i++){
            for(int j = 0; j < jobs.length; j++){
                if(!visited[j] && jobs[j][0] <= time){
                    visited[j] = true;
                    pq.offer(new int[]{jobs[j][0], jobs[j][1]});
                }
            }
            
            if (pq.isEmpty()) {
                for (int j = 0; j < jobs.length; j++) {
                    if (!visited[j]) {
                        time = jobs[j][0];
                        break;
                    }
                }
                i--;
                continue;
            }
            
            int[] curr = pq.poll();
            int accessT = curr[0];
            int runT = curr[1];
            
            time += runT;
            
            resTime += time - accessT;
        }
        
        resTime /= jobs.length;
    }
}