package 프로그래머스.레벨1.문자열_다루기_기본;

public class Solution {
    public boolean solution(String s) {
        return isRightLength(s) && isNumberSet(s) ? true : false;
    }

    private boolean isRightLength(String s) {
        int len = s.length();
        return len==4 || len==6 ? true : false;
    }

    private boolean isNumberSet(String s) {
        for(char c: s.toCharArray()) {
            if(c<'0' || c>'9')
                return false;
        }
        return true;
    }
}