import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int start = 0; start < elements.length; start++){

            int sum = 0;
            for(int i = 0; i < elements.length; i++){
                sum += elements[(start + i) % elements.length];
                
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}