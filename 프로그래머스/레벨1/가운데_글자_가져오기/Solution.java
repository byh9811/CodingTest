package 프로그래머스.레벨1.가운데_글자_가져오기;

public class Solution {
    public String solution(String s) {
        int length = s.length();
        if(length%2==0)
            return s.substring(length/2-1, length/2+1);
        else
            return s.substring(length/2, length/2+1);
    }
}