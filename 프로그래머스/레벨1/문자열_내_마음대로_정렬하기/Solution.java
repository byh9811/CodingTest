package 프로그래머스.레벨1.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.charAt(n)==o2.charAt(n))
                return o1.compareTo(o2);
            return o1.charAt(n)-o2.charAt(n);
        });
        return strings;
    }
}