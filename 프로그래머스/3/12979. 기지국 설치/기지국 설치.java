class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int elecCnt = 0;
        int frontPos = 1;
        
        for(int pos: stations){
            int firstPos = frontPos;
            
            int currCnt = (pos - w - firstPos) / (w * 2 + 1);
            
            if(currCnt * (w * 2 + 1) < pos - w - firstPos){
                elecCnt += currCnt + 1;
            }
            
            else{
                elecCnt += currCnt;
            }
            
            frontPos = pos + w + 1;
        }
        
        if(frontPos <= n){
            int etc = n - frontPos + 1;
            if(etc > 0){
                if(etc >= w * 2 + 1){
                    int currCnt = etc / (w * 2 + 1);
                    
                    if(currCnt * (w * 2 + 1) < etc){
                        elecCnt += currCnt + 1;
                    }
                    
                    else{
                        elecCnt += currCnt;
                    }
                }
                
                else{
                    elecCnt++;   
                }
            }
        }

        return elecCnt;
    }
}