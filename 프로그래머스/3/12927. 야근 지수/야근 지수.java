import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        
        for(int num: works){
            pq.add(num);
        }
        
        while(n > 0){
            int num = pq.poll();
            if(num == 0){
                break;
            }
            
            num -= 1;
            pq.add(num);
            n--;
        }
        
        for(int num: pq){
            answer += Math.pow(num, 2);
        }
        
        return answer;
    }
}