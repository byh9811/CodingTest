package 프로그래머스.레벨1.나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        for(int elem: arr) {
            if(elem%divisor==0)
                answer.add(elem);
        }

        if(answer.size()==0)
            answer.add(-1);

        answer.sort(null);

        return answer;
    }
}