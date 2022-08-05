package 실전용;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        ArrayList<Integer>[] answer = new ArrayList[servers];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<servers; i++)
            answer[i] = new ArrayList<>();

        int next = 0;
        for(int i=0; i<requests.length; i++) {
            int request = requests[i];
            if(sticky) {
                if(map.containsKey(request)) {
                    int cur = map.get(request);
                    answer[cur].add(request);
                    next = (cur+1) % servers;
                } else {
                    answer[next].add(request);
                    map.put(request, next);
                    next = (next+1) % servers;
                }
            } else {
                answer[next].add(request);
                next = (next+1) % servers;
            }
        }

        int[][] ret = new int[servers][];
        for(int i=0; i<servers; i++)
            ret[i] = answer[i].stream().mapToInt(x -> x).toArray();

        return ret;
    }
}