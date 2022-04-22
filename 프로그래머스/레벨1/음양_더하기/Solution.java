package 프로그래머스.레벨1.음양_더하기;

public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;

        for(int i=0; i<absolutes.length; i++) {
            boolean isPos = signs[i];
            int num = absolutes[i];
            if(isPos)
                sum += num;
            else
                sum -= num;
        }

        return sum;
    }
}