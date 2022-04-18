package 프로그래머스.고득점_Kit.스택_및_큐.기능개발;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int completeIdx = 0;
        for(int day=1; day<100; day++) {
            int completeNum = 0;
            for(;completeIdx<progresses.length; completeIdx++) {
                if((progresses[completeIdx] + (speeds[completeIdx]*day)) < 100)
                    break;
                completeNum++;
            }
            if(completeNum!=0)
                answer.add(completeNum);
        }
        return answer;
    }
}