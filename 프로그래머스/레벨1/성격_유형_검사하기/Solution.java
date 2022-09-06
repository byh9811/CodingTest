package 프로그래머스.레벨1.성격_유형_검사하기;

import java.util.HashMap;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);

        for(int i=0; i<survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int dif = choices[i]-4;

            if(dif>0)
                score.put(second, score.get(second)+dif);
            else if(dif<0)
                score.put(first, score.get(first)-dif);
        }

        String answer = "";
        answer += score.get('R')<score.get('T') ? 'T' : 'R';
        answer += score.get('C')<score.get('F') ? 'F' : 'C';
        answer += score.get('J')<score.get('M') ? 'M' : 'J';
        answer += score.get('A')<score.get('N') ? 'N' : 'A';

        return answer;
    }
}