package 프로그래머스.레벨1.푸드_파이트_대회;

public class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++)
                sb.append(i);
        }
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(0).append(sb.reverse());
        return sb2.toString();
    }
}