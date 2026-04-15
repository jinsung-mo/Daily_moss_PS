import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        answer = "" + min + " " + max;
        
        return answer;
    }
}