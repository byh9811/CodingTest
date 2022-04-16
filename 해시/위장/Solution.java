package 해시.위장;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(String[] cloth: clothes) {
            if(!clothesMap.containsKey(cloth[1]))
                clothesMap.put(cloth[1], 0);
            clothesMap.put(cloth[1], clothesMap.get(cloth[1])+1);
        }

        int answer = 1;
        for(int value: clothesMap.values())
            answer *= value+1;

        return answer-1;
    }
}