package 프로그래머스.레벨2.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> appeared = new HashSet<>();
        int turn = 0;
        char prev = words[0].charAt(0);

        for(String word: words) {
            if(prev==word.charAt(0) && !appeared.contains(word)) {      // 통과
                turn++;
                prev = word.charAt(word.length()-1);
                appeared.add(word);
            } else {        // 탈락
                answer[0] = turn%n+1;
                answer[1] = turn/n+1;
                break;
            }
        }

        return answer;
    }
}