package 해시.완주하지_못한_선수;

import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;

        for(; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;

            }
        }

        if(i==completion.length)
            answer = participant[i];

        return answer;
    }
}