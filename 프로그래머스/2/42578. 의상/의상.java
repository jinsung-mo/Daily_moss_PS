import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] kind: clothes){
            map.put(kind[1], map.getOrDefault(kind[1], 0) + 1);
        }
        
        int result = 1;
        for(int count: map.values()){
            result *= (count + 1);
        }
        
        return result - 1;
    }
}