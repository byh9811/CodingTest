package 프로그래머스.레벨1.과일_장수;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for(int i=m-1; i<score.length; i+=m)
            answer += score[i] * m;

        return answer;
    }
}