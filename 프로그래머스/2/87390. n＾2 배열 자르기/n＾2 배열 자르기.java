import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right - left + 1)];
        
        for(long i = left; i <= right; i++){
            int row = (int)(i / n);
            int col = (int)(i % n);
            
            int target = Math.max(row, col) + 1;
            
            result[(int)(i - left)] = target;
        }
        
        return result;
    }
}