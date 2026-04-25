class Solution {
    int[] p1 = {-1, 1};
    int[] p2 = {1, -1};
        
    public long solution(int[] sequence) {
        long[] p1_seq = new long[sequence.length];
        long[] p2_seq = new long[sequence.length];
        long p1Max = Integer.MIN_VALUE;
        long p2Max = Integer.MIN_VALUE;
        
        p1_seq[0] = sequence[0] * p1[0];
        p2_seq[0] = sequence[0] * p2[0];
        for(int i = 1; i < sequence.length; i++){
            p1_seq[i] = p1_seq[i - 1] + sequence[i] * p1[i % 2];
            p2_seq[i] = p2_seq[i - 1] + sequence[i] * p2[i % 2];
        }
        
        p1Max = partSum(p1_seq);
        p2Max = partSum(p2_seq);
        
        return Math.max(p1Max, p2Max);
    }
    
    private long partSum(long[] sum){
        long max = 0;
        long min = 0;
        for(long part: sum){
            max = Math.max(max, part);
            min = Math.min(min, part);
        }
        
        return max - min;
    }
}