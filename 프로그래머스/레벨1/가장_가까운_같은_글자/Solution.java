package 프로그래머스.레벨1.가장_가까운_같은_글자;

import java.util.HashMap;

public class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> idx = new HashMap<>();

        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(idx.containsKey(c))
                answer[i] = i - idx.get(c);
            else
                answer[i] = -1;
            idx.put(c, i);
        }

        return answer;
    }
}