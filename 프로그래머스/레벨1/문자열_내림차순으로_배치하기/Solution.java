package 프로그래머스.레벨1.문자열_내림차순으로_배치하기;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for(int i=charArr.length-1; i>=0; i--)
            sb.append(charArr[i]);

        return sb.toString();
    }
}