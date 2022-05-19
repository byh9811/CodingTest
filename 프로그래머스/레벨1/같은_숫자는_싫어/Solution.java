package 프로그래머스.레벨1.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int prev = -1;

        for(int elem: arr) {
            if(elem==prev)
                continue;
            prev = elem;
            answer.add(elem);
        }

        return answer;
    }
}