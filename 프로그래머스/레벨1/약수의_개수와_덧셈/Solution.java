package 프로그래머스.레벨1.약수의_개수와_덧셈;

public class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<right+1; i++) {
            double rootVal = Math.sqrt(i);
            if(rootVal==(int)rootVal)
                answer -= i;
            else
                answer += i;
        }

        return answer;
    }
}