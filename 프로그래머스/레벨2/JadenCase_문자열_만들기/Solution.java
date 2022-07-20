package 프로그래머스.레벨2.JadenCase_문자열_만들기;

import java.util.Locale;

public class Solution {
    public String solution(String s) {
        boolean isFirstChar = true;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            String c = s.substring(i, i+1);

            if(c.equals(" ")) {
                isFirstChar = true;
            } else if(isFirstChar) {
                isFirstChar = false;
                c = c.toUpperCase();
            } else {
                c = c.toLowerCase();
            }
            sb.append(c);
        }

        return sb.toString();
    }
}