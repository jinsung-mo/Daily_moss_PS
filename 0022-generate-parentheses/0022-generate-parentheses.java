class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        backtrack(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, int open, int close, int max){
        if(curr.length() == max * 2){
            res.add(curr.toString());

            return;
        }

        if(open < max){
            curr.append('(');
            backtrack(res, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(')');
            backtrack(res, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}