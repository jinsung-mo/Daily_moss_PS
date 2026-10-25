class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] extTasks = new int[n][3];
        for(int i = 0; i < n; i++){
            extTasks[i][0] = tasks[i][0];
            extTasks[i][1] = tasks[i][1];
            extTasks[i][2] = i;
        }

        Arrays.sort(extTasks, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        int[] res = new int[n];
        int resIdx = 0;
        int taskIdx = 0;

        long currTime = 0;
        while(resIdx < n){
            if(pq.isEmpty() && currTime < extTasks[taskIdx][0]){
                currTime = extTasks[taskIdx][0];
            }

            while(taskIdx < n && extTasks[taskIdx][0] <= currTime){
                pq.offer(extTasks[taskIdx]);
                taskIdx++;
            }

            int[] currTask = pq.poll();
            res[resIdx++] = currTask[2];
            currTime += currTask[1];
        }

        return res;
    }
}