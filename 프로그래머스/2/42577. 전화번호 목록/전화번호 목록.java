import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for(String phone: phone_book){
            set.add(phone);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String prev_str = "";
            for(int j = 0; j < phone_book[i].length() - 1; j++){
                prev_str += phone_book[i].charAt(j);
                
                if(set.contains(prev_str)){
                    return false;
                }
            }
        }
        
        return true;
    }
}