class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num: nums){
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return cntMap.get(a) - cntMap.get(b);
        });

        for(int key: cntMap.keySet()){
            pq.add(key);

            if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}