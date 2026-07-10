import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int result = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int size = 1; size <= elements.length; size++){
            for(int start = 0; start < elements.length; start++){
                
                int sum = 0;
                for(int i = 0; i < size; i++){
                    sum += elements[(start + i) % elements.length];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }
}