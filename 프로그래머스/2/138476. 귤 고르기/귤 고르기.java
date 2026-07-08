import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int kind_cnt = 0;
        for(int kind: counts){
            k -= kind;
            kind_cnt++;
            
            if(k <= 0) break;
        }
        
        return kind_cnt;
    }
}