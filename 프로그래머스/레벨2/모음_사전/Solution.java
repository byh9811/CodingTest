package 프로그래머스.레벨2.모음_사전;

import java.util.HashMap;

public class Solution {
    public int solution(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        int answer = 0;
        int[] costForRotate = {781, 156, 31, 6, 1};

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            answer += costForRotate[i] * (map.get(c)-1) + 1;
        }

        return answer;
    }
}