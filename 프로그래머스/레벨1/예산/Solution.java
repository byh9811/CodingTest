package 프로그래머스.레벨1.예산;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int elem: d) {
            budget -= elem;
            if(budget>=0)
                answer++;
            else
                break;
        }

        return answer;
    }
}