package 프로그래머스.레벨1.명예의_전당;

import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<score.length; i++) {
            pq.add(score[i]);

            if(pq.size()>k)
                pq.poll();

            answer[i] = pq.peek();
        }

        return answer;
    }
}