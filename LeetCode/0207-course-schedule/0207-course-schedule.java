class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        buildGraph(numCourses, prerequisites, graph, indegree);

        return isTopoSortPossible(numCourses, graph, indegree);
    }

    private void buildGraph(int numCourses, int[][] prerequisites, Map<Integer, List<Integer>> graph, int[] indegree){
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
    }

    private boolean isTopoSortPossible(int numCourses, Map<Integer, List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int completedCourses = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            completedCourses++;

            for(int next: graph.get(curr)){
                indegree[next]--;

                if(indegree[next] == 0) q.offer(next);
            }
        }

        return completedCourses == numCourses;
    }
}