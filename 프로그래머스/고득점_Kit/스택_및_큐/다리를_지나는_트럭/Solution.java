package 프로그래머스.고득점_Kit.스택_및_큐.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++)
            q.add(0);

        int curW = 0;
        int curT = 0;

        for(int truck_weight: truck_weights) {
            while(true) {
                curW -= q.poll();
                curT++;

                if(curW+truck_weight<=weight) {
                    q.add(truck_weight);
                    curW += truck_weight;
                    break;
                } else {
                    q.add(0);
                }
            }
        }

        return curT + bridge_length;
    }
}