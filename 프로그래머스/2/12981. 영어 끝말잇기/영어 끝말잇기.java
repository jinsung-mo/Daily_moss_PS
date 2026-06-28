import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        HashSet<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        char prevWord = words[0].charAt(words[0].length() - 1);
        int targetPersonNum = 0;
        int targetPersonTime = 0;
        for(int i = 1; i < words.length; i++){
            if(usedWords.contains(words[i]) || words[i].charAt(0) != prevWord){
                if((i + 1) % n == 0){
                    targetPersonNum = n;
                } else {
                    targetPersonNum = (i + 1) % n;
                }
                
                targetPersonTime = i / n + 1;
                
                break;
            }
            
            usedWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }
        
        answer = new int[]{targetPersonNum, targetPersonTime};
    
        return answer;
    }
}