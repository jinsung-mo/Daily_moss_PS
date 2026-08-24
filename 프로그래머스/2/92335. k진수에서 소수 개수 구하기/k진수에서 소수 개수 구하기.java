import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String num = change(n, k);
        StringTokenizer st = new StringTokenizer(num, "0");
        int count = 0;
        
        while(st.hasMoreTokens()){
            String isPrime = st.nextToken();
            
            if(prime(isPrime)) count++;
        }
        
        return count;
    }
    
    private String change(long num, int k){
        StringBuilder sb = new StringBuilder();
        long remain = num;
        
        while(num >= k){
            sb.append(num % k);
            num /= k;
        }
        
        sb.append(num);
        
        return sb.reverse().toString();
    }
    
    private boolean prime(String n){
        long num = Long.parseLong(n);
        
        if(num <= 1) return false;
        
        for(long i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}