import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = createMultiSet(str1);
        Map<String, Integer> map2 = createMultiSet(str2);
        
        Set<String> set = new HashSet<>(map1.keySet());
        set.addAll(map2.keySet());
        
        int ins = 0;
        int union = 0;
        for(String key: set){
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);
                
            ins += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);
        }
        
        if(ins == 0 && union == 0) return 65536;
        
        return (int) ((double) ins / union * 65536);
    }
    
    private Map<String, Integer> createMultiSet(String str){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 1; i++){
            String newStr = "" + str.charAt(i) + str.charAt(i + 1);
            
            if(newStr.charAt(0) >= 'a' && newStr.charAt(0) <= 'z' && newStr.charAt(1) >= 'a' && newStr.charAt(1) <= 'z')
                map.put(newStr, map.getOrDefault(newStr, 0) + 1);
        }
        
        return map;
    }
}