class Solution {
    public int solution(String s) {
        int maxOneLen = 0;
        int maxTwoLen = 0;
        
        for(int i = 0; i < s.length(); i++){
            maxOneLen = Math.max(maxOneLen, pd(s, i, i));
            maxTwoLen = Math.max(maxTwoLen, pd(s, i, i + 1));
        }
        
        return Math.max(maxOneLen - 1, maxTwoLen);
    }
    
    private int pd(String s, int left, int right){
        int count = 0;
        while(isRange(left, right, s)){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                count++;
            }
            else break;
        }
        
        return count * 2;
    }
    
    private boolean isRange(int left, int right, String s){
        return left >= 0 && right < s.length();
    }
}