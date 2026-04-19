import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> finalIdx = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        while(!map.isEmpty()){
            int max = 0;
            String maxGenre = "";
            for(String genre: map.keySet()){
                if(map.get(genre) > max){
                    max = map.get(genre);
                    maxGenre = genre;
                }
            }
            
            map.remove(maxGenre);
            
            List<int[]> currIdx = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(maxGenre)){
                    currIdx.add(new int[]{i, plays[i]});
                }
            }
            
            Collections.sort(currIdx, (a, b) -> {
                if(a[1] == b[1]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
            
            for(int i = 0; i < currIdx.size(); i++){
                finalIdx.add(currIdx.get(i)[0]);
                
                if(i == 1) break;
            }
        }
        
        int[] answer = new int[finalIdx.size()];
        int i = 0;
        for(int num: finalIdx){
            answer[i++] = num;
        }
        
        return answer;
    }
}