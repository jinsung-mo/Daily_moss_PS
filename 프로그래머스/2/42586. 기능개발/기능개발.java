import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int endProgress = 0;
            int endWork = progresses[i];
            while(endWork < 100){
                endWork += speeds[i];
                endProgress++;
            }
            
            q.offer(endProgress);
        }
        
        List<Integer> list = new ArrayList<>();
        int prevEnd = 0;
        int dayCnt = 1;
        for(int end: q){
            if(prevEnd == 0){
                prevEnd = end;
                continue;
            }
            
            if(prevEnd >= end){
                dayCnt++;
            } else {
                prevEnd = end;
                list.add(dayCnt);
                dayCnt = 1;
            }
        }
        
        list.add(dayCnt);
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}