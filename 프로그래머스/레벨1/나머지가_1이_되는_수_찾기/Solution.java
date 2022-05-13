package 프로그래머스.레벨1.나머지가_1이_되는_수_찾기;

public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++)
            answer += a[i] * b[i];

        return answer;
    }
}