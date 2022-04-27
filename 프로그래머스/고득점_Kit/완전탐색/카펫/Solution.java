package 프로그래머스.고득점_Kit.완전탐색.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int x = (((brown+4)/2) + (int)Math.sqrt(((brown+4)/2)*((brown+4)/2)-(4*(brown+yellow)))) / 2;
        int y = (((brown+4)/2) - (int)Math.sqrt(((brown+4)/2)*((brown+4)/2)-(4*(brown+yellow)))) / 2;

        int[] answer = { x, y };
        return answer;
    }
}