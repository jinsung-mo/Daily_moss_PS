import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i = 0; i < n; i++){
            int citation = citations[i];
            
            int count = n - i;
            
            if(citation >= count){
                return count;
            }
        }
        
        return 0;
    }
}