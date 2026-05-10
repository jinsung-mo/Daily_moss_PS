import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int result1 = 0;
        int result2 = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            result1 += A[i] * B[A.length - 1 - i];
            result2 += B[i] * A[A.length - 1 - i];
        }
        
        return Math.min(result1, result2);
    }
}