package 프로그래머스.레벨2.압축;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int startIdx = 0;

        for(int i=0; i<26; i++)
            dict.put(Character.toString('A'+i), i+1);

        while(true) {
            int endIdx = startIdx;

            while(endIdx<msg.length() && dict.containsKey(msg.substring(startIdx, endIdx+1)))
                endIdx++;

            if(endIdx==msg.length()) {
                answer.add(dict.get(msg.substring(startIdx, endIdx)));
                break;
            }

            answer.add(dict.get(msg.substring(startIdx, endIdx)));
            dict.put(msg.substring(startIdx, endIdx+1), dict.size()+1);
            startIdx = endIdx;
        }

        return answer;
    }
}