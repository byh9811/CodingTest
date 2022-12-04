package 프로그래머스.레벨1.문자열_나누기;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = 'A';
        int firstCnt = 0;
        int otherCnt = 0;

        for(char c: s.toCharArray()) {
            if(firstCnt==0) {
                firstCnt++;
                x = c;
            } else {
                if(c==x)
                    firstCnt++;
                else
                    otherCnt++;
            }

            if(firstCnt==otherCnt) {
                firstCnt = 0;
                otherCnt = 0;
                answer++;
            }
        }

        return firstCnt==0 ? answer : answer+1;
    }
}