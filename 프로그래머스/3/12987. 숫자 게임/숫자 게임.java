import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int winCntB = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        while(i < B.length) {
            if(A[j] < B[i]) {
                i++;
                j++;
                winCntB++;
            }
            
            else {
                i++;
            }
        }
        
        return winCntB;
    }
}

