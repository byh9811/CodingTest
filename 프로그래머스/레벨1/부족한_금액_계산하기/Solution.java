package 프로그래머스.레벨1.부족한_금액_계산하기;

public class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1; i<=count; i++)
            answer += price * i;

        return answer>money ? answer-money : 0;
    }
}