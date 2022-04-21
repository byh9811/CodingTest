package 프로그래머스.고득점_Kit.힙.더_맵게;

import java.util.*;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco: scoville)
            pq.add(sco);

        while(true) {
            count++;
            int mildest = pq.poll();
            int mildnd = pq.poll();
            pq.add(mildest+(2*mildnd));

            if(pq.peek()>=K) {
                answer = count;
                break;
            } else if(pq.size()<2) {
                break;
            }
        }

        return answer;
    }
}