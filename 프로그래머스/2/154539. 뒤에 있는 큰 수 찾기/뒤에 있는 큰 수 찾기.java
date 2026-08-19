import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        
        for(int i = 1; i < numbers.length; i++){
            
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                if(numbers[stack.peek()] < numbers[i]) {
                    result[stack.peek()] = numbers[i];
                    stack.pop();
                }
            }
              
            stack.push(i);
        }
        
        return result;
    }
}