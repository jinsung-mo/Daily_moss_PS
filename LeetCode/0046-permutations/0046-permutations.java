class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], res);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            curr.add(nums[i]);
            backtrack(nums, curr, visited, res);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}