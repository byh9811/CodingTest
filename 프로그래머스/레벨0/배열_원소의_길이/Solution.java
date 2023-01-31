package 프로그래머스.레벨0.배열_원소의_길이;

public class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for(int i=0; i<answer.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}