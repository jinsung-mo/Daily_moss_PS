class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int min;
        int result = 2; //왼쪽, 오른쪽 끝은 모두 가능
        
        min = a[0];
        for(int i = 1; i < a.length; i++){
            leftMin[i] = min;
            min = Math.min(min, a[i]);
        }
        
        min = a[a.length - 1];
        for(int i = a.length - 2; i >= 0; i--){
            rightMin[i] = min;
            min = Math.min(min, a[i]);
        }
        
        for(int i = 1; i < a.length - 1; i++){
            if(leftMin[i] > a[i] || rightMin[i] > a[i])
                result++;
        }
        
        return result;
    }
}