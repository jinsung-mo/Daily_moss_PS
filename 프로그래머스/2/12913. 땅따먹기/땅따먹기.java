import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        int maxVal = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                
                int rowMax = 0;
                for(int k = 0; k < 4; k++){
                    if(k == j) continue;
                    
                    rowMax = Math.max(rowMax, dp[i - 1][k]);
                }
                
                dp[i][j] = land[i][j] + rowMax;
                
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        
        return maxVal;
    }
}