class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();

        Map<Character, String> digitToLetters = buildDigitMap();
        List<String> res = new ArrayList<>();

        backtrack(digits, 0, new StringBuilder(), digitToLetters, res);

        return res;
    }
    
    private Map<Character, String> buildDigitMap(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }

    private void backtrack(String digits, int idx, StringBuilder curr, Map<Character, String> digitToLetters, List<String> res){
        if(idx == digits.length()){
            res.add(curr.toString());
            
            return;
        }

        char digit = digits.charAt(idx);
        String letters = digitToLetters.get(digit);

        for(int i = 0; i < letters.length(); i++){
            char letter = letters.charAt(i);

            curr.append(letter);
            backtrack(digits, idx + 1, curr, digitToLetters, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}