import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= t * m; i++){
            sb.append(conv(n, i));
        }
        
        String fullNum = sb.toString();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = 1; i <= fullNum.length(); i++){
            if(count == t) break;
            
            if(p == i % m || (p == m && i % m == 0)){
                result.append(fullNum.charAt(i - 1));
                count++;
            }
        }
        
        return result.toString();
    }
    
    private StringBuilder conv(int n, int num){
        String digits = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        int target = num;
        int remain = 0;
        
        while(target >= n){
            remain = target % n;
            sb.append(digits.charAt(remain));
            target = target / n;
        }
        
        sb.append(digits.charAt(target));
        
        return sb.reverse();
    }
}