import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        int minLen = gems.length;
        LinkedHashSet<String> set = new LinkedHashSet<>();
        Map<String, Integer> record = new HashMap<>();
        
        for(String gem: gems){set.add(gem);}
        
        int right = 0;
        Set<String> curr = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            curr.add(gems[i]);
            
            record.put(gems[i], record.getOrDefault(gems[i], 0) + 1);
            
            if(set.size() == curr.size()){
                right = i;
                break;
            }
        }
        
        int left = 0;
        
        while(right < gems.length){
            while(record.size() == set.size()){
                if(minLen > right - left){
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                record.put(gems[left], record.get(gems[left]) - 1);
                if(record.get(gems[left]) == 0){
                    record.remove(gems[left]);
                } 
                
                left++;
            }
            
            right++;
            if(right < gems.length){record.put(gems[right], record.getOrDefault(gems[right], 0) + 1);
            }
        }
        
        return answer;
    }
}