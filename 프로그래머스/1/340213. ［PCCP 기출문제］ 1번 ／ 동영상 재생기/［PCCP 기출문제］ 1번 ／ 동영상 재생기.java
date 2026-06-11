import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String currPos = pos;
        
        StringTokenizer videost = new StringTokenizer(video_len, ":");
        StringTokenizer pst = new StringTokenizer(pos, ":");
        StringTokenizer opsst = new StringTokenizer(op_start, ":");
        StringTokenizer opest = new StringTokenizer(op_end, ":");
        
        int vidFirst = Integer.parseInt(videost.nextToken());
        int vidLast = Integer.parseInt(videost.nextToken());
        int posFirst = Integer.parseInt(pst.nextToken());
        int posLast = Integer.parseInt(pst.nextToken());
        int opsFirst = Integer.parseInt(opsst.nextToken());
        int opsLast = Integer.parseInt(opsst.nextToken());
        int opeFirst = Integer.parseInt(opest.nextToken());
        int opeLast = Integer.parseInt(opest.nextToken());
        
        int vidSec = vidFirst * 60 + vidLast;
        int posSec = posFirst * 60 + posLast;
        int opStartSec = opsFirst * 60 + opsLast;
        int opLastSec = opeFirst * 60 + opeLast;
        
        for(String cmd : commands){
            if(posSec >= opStartSec && posSec <= opLastSec){
                posSec = opLastSec;
            }
            
            if(cmd.equals("prev")){
                if(posSec < 10)
                    posSec = 0;
                else
                    posSec -= 10;
            } else {
                if(posSec > vidSec - 10)
                    posSec = vidSec;
                else
                    posSec += 10;
            }
            
            if(posSec >= opStartSec && posSec <= opLastSec){
                posSec = opLastSec;
            }
        }
        
        int m = posSec / 60;
        int s = posSec - m * 60;
        
        if(m < 10){
            if(s < 10)
                answer = "0" + m + ":" + "0" + s;
            else
                answer = "0" + m + ":" + s;
        } else {
            if(s < 10)
                answer = m + ":" + "0" + s;
            else
                answer = m + ":" + s;
        }
        return answer;
    }
}