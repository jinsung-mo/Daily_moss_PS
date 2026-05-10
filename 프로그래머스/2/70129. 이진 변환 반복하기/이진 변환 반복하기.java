import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int oneCnt = 0;
        int changeCnt = 0;
        String currS = s;
        int[] result = new int[2];
        
        while(!currS.equals("1")){
            int currZeroCnt = 0;
            int currOneCnt = 0;
            for(int i = 0; i < currS.length(); i++){
                if(currS.charAt(i) == '0') currZeroCnt++;
                else currOneCnt++;
            }
            
            zeroCnt += currZeroCnt;
            
            currS = changeBinary(currOneCnt);
            
            changeCnt++;
        }
        
        result[0] = changeCnt;
        result[1] = zeroCnt;
        
        return result;
    }
    
    private String changeBinary(int num){
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
}