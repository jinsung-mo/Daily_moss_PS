import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b){
        int n = 0;
        
        while(b != 0){
            n = a % b;
            a = b;
            b = n;
        }
        
        return a;
    }
    
    private int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}