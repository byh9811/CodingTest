package 프로그래머스.고득점_Kit.스택_및_큐.프린터;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorites, int location) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for(int priority: priorites)
            q.add(priority);
        Arrays.sort(priorites);
        int idx = priorites.length-1;

        while(true) {
            int priority = q.poll();
            if(priority==priorites[idx]) {
                if(location==0) {
                    answer++;
                    break;
                } else {
                    answer++;
                    location--;
                    idx--;
                }
            } else {
                if(location==0)
                    location = q.size();
                else
                    location--;
                q.add(priority);
            }
        }

        return answer;
    }
}