class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100_000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            long result_time = 0;
            
            for(int i = 0; i < diffs.length; i++){
                if(i == 0){
                    result_time = provTime(mid, diffs[i], times[i], 0);
                } else {
                    result_time += provTime(mid, diffs[i], times[i], times[i - 1]);
                }
                

            }
            
            if(result_time > limit){
                left = mid + 1;
            }
            
            else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int provTime(int level, int diff, int time_cur, int time_prev){
        int result = 0;
        int result_time = 0;
        
        if(level < diff){
            int count = diff - level;
            int sumTime = time_cur + time_prev;
            
            result_time = count * sumTime + time_cur;
        } 
        
        else {
            result_time = time_cur;
        }
        
        return result_time;
    }
}