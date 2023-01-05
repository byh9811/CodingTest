package 프로그래머스.레벨0.머쓱이보다_키_큰_사람;

public class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int elem: array) {
            if(elem>height)
                answer++;
        }
        return answer;
    }
}