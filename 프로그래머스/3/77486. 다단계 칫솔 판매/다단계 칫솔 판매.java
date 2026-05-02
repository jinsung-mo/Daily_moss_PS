import java.util.*;

class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> profit = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for(int i = 0; i < enroll.length; i++){
            parent.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
        
        profit(seller, amount);
        
        int[] result = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            result[i] = profit.get(enroll[i]);
        }
        
        return result;
    }
    
    private void profit(String[] seller, int[] amount){
        for(int i = 0; i < seller.length; i++){
            int price = amount[i] * 100;
            String currSeller = seller[i];
            
            while(true){
                int currPrice = price - price / 10;
                profit.put(currSeller, profit.get(currSeller) + currPrice);
                
                String nextSeller = parent.get(currSeller);
                if(nextSeller.equals("-")) break;
                currSeller = nextSeller;
                
                price = price / 10;
                if(price == 0) break;
            }
        }
    }
}