import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((from, to) -> {
            return Integer.compare(from, to);
        });
        
        for(int scov: scoville){
            pq.offer(scov);
        }
        
        int result = 0;
        int count = 0;
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            
            int first = pq.poll();
            int last = pq.poll();
            
            result = first + (last * 2);
            
            pq.offer(result);
            count++;
        }
        
        return count;
    }
}