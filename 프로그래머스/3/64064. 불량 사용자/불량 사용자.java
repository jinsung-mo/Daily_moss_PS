import java.util.*;

class Solution {
    static List<List<String>> candidate = new ArrayList<>();
    static Set<Set<String>> set = new HashSet<>();
    static Set<String> serveSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        for(String ban: banned_id){
            List<String> list = new ArrayList<>();
            
            for(String user: user_id){
                if(match(user, ban)){
                    list.add(user);
                }
            }
            
            candidate.add(list);
        }
        
        dfs(0, banned_id.length);
        
        return set.size();
    }
    
    private static boolean match(String user, String ban){
        if(user.length() != ban.length()) return false;
        
        for(int i = 0; i < user.length(); i++){
            int ch1 = user.charAt(i);
            int ch2 = ban.charAt(i);
            
            if(ch2 == '*') continue;
            
            if(ch1 != ch2) return false;
        }
        
        return true;
    }
    
    private static void dfs(int idx, int banSize){
        if(idx == banSize){
            set.add(new HashSet<>(serveSet));
            return;
        }
        
        for(String curr: candidate.get(idx)){
            if(!serveSet.contains(curr)){
                serveSet.add(curr);
                dfs(idx + 1, banSize);
                serveSet.remove(curr);
            }
        }
    }
}



