import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new ArrayDeque<>();
        int runningTime = 0;
        
        for(String city: cities){
            city = city.toLowerCase();
            
            if(q.contains(city)){
                System.out.println("hit");
                q.remove(city);
                q.offer(city);
                runningTime += 1;
            } else {
                if(cacheSize == 0){
                    runningTime = cities.length * 5;
                    break;
                }
                if(q.size() == cacheSize){
                    q.poll();
                    q.offer(city);
                } else {
                    q.offer(city);
                }
                
                runningTime += 5;
            }
        }
        
        return runningTime;
    }
}