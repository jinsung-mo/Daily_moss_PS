import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        
        int mid = s / n;
        int add = s % n;
        
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            if(add > 0){
                answer[i] = mid + 1;
                add--;
            }
            
            else{
                answer[i] = mid;
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}