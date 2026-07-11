import java.util.*;

class Solution {
    public int solution(String s) {
        
        return possibleCnt(s);
    }
    
    private int possibleCnt(String s){
        int count = 0;
        
        Stack<Character> stack = new Stack<>();
    
        for(int i = 0; i < s.length(); i++){
            boolean flag = true;
            for(int j = 0; j < s.length(); j++){
                if(stack.isEmpty()){
                    if(s.charAt(j) == ']' || s.charAt(j) == ')' || s.charAt(j) == '}'){
                        flag = false;
                        break;
                    }
                }
                
                if(s.charAt(j) == '[' || s.charAt(j) == '(' || s.charAt(j) == '{'){
                    stack.push(s.charAt(j));
                }
                
                else if(s.charAt(j) == ']' && stack.peek() == '[') stack.pop();
                else if(s.charAt(j) == '}' && stack.peek() == '{') stack.pop();
                else if(s.charAt(j) == ')' && stack.peek() == '(') stack.pop();
            }
            
            if(flag && stack.isEmpty()) count++;
            
            s = rotate(s);
        }
        
        return count;
    }
    
    private String rotate(String s){
        char tmp = s.charAt(0);
        s = s.substring(1) + tmp;
        
        return s;
    }
}