package 프로그래머스.레벨2.n진수_게임;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Character> map;

    public String solution(int n, int t, int m, int p) {
        map = new HashMap<>();
        for(int i=0; i<10; i++)
            map.put(i, (char)(i+'0'));
        for(int i=10; i<16; i++)
            map.put(i, (char)(i+55));

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int cur = 0;

        while(sb.length()<m*t)
            sb.append(convert(cur++, n));

        for(int i=p-1; i<m*t; i+=m)
            answer.append(sb.charAt(i));

        return answer.toString();
    }

    private String convert(int num, int n) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.append(map.get(num%n));
            num /= n;
        } while(num>0);

        return sb.reverse().toString();
    }
}