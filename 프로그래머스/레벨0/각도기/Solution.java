package 프로그래머스.레벨0.각도기;

public class Solution {
    public int solution(int angle) {
        if(angle<90)
            return 1;
        else if(angle==90)
            return 2;
        else if(angle<180)
            return 3;
        else
            return 4;
    }
}