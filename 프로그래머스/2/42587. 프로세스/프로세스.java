import java.util.*;

class Node {
    int idx = 0;
    int num = 0;
    
    public Node(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new ArrayDeque<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(b.num, a.num)                                            
        );
        
        Node target = new Node(location, priorities[location]);
        
        int idx = 0;
        for(int process: priorities){
            q.offer(new Node(idx, process));
            pq.offer(new Node(idx++, process));
        }
        
        int processCnt = 1;
        while(!q.isEmpty()){
            Node currProcess = q.poll();
            Node maxProcess = pq.peek();
            
            if(currProcess.num < maxProcess.num){
                q.offer(currProcess);
            } else {
                if(target.idx == currProcess.idx){
                    break;
                } else {
                    pq.poll();
                    processCnt++;
                }
            }
        }
        
        return processCnt;
    }
}