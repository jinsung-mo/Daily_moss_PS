class Solution {
    public int solution(int[] stones, int k) {
        int result = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for(int stone: stones){
            left = Math.min(left, stone);
            right = Math.max(right, stone);
        }
        
        while(left <= right){
            int mid = (left + right) / 2; 
            
            if(isAble(stones, k, mid))
                left = mid + 1;
            
            else
                right = mid - 1;
            
            result = mid;
        }
        
        if((left + right) % 2 == 0)
            result = (left + right) / 2;
        else
            result = (left + right) / 2 + 1;
        
        return result;
    }
    
    private boolean isAble(int[] stones, int k, int mid){
        int count = 0;
        
        for(int i = 0; i < stones.length; i++){
            if(stones[i] <= mid)
                count++;
            
            else
                count = 0;
            
            if(count == k){
                return false;
            }
        }
        
        return true;
    }
}





