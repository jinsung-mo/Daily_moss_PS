class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long)times[times.length - 1] * n;
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long sumTime = 0;
            for(int time: times){
                sumTime += mid / time;
            }
            
            if(sumTime >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
            
            
        }
        
        
        return answer;
    }
}