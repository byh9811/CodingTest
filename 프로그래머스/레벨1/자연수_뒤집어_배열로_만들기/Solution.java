package 프로그래머스.레벨1.자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;

public class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();

        while(n>0) {
            answer.add((int)(n%10));
            n /= 10;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}