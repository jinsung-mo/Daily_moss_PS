import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            int nx = x;
            int ny = y;
            
            if(dirs.charAt(i) == 'U') ny--;
            else if(dirs.charAt(i) == 'D') ny++;
            else if(dirs.charAt(i) == 'L') nx--;
            else nx++;
            
            if(!isRange(ny, nx)) continue;
            
            String dir1 = "" + x + "" + y + "" + nx + "" + ny;
            String dir2 = "" + nx + "" + ny + "" + x + "" + y;
            
            set.add(dir1);
            set.add(dir2);
            
            x = nx;
            y = ny;
        }
        
        return set.size() / 2;
    }
    
    private boolean isRange(int y, int x){
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
}