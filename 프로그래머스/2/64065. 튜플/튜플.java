import java.util.*;

class Data{
    int length = 0;
    Integer[] list = {};

    public Data(int length, Integer[] list){
        this.length = length;
        this.list = list;
    }
}

class Solution {
    public int[] solution(String s) {
        String[] tupleArr = s.substring(2, s.length() - 2).split("\\},\\{");

        List<Data> tuple = new ArrayList<>();

        for(String str : tupleArr){
            StringTokenizer num = new StringTokenizer(str, ",");

            List<Integer> list = new ArrayList<>();

            while(num.hasMoreTokens()){
                list.add(Integer.parseInt(num.nextToken()));
            }

            Data set = new Data(list.size(), list.toArray(new Integer[0]));

            tuple.add(set);
        }

        tuple.sort((a, b) -> {
            return Integer.compare(a.length, b.length);
        });

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int i = 0; i < tuple.size(); i++){
            for(int j = 0; j < tuple.get(i).list.length; j++){
                set.add(tuple.get(i).list[j]);
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;

        for(int num : set){
            answer[idx++] = num;
        }

        return answer;
    }
}