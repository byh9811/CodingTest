package 프로그래머스.레벨2.뉴스_클러스터링;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> union = new HashMap<>();
        int unionSize = 0;
        int intersectionSize = 0;

        addWords(map1, str1);
        addWords(map2, str2);

        for(Entry<String, Integer> entry: map1.entrySet()) {
            String word = entry.getKey();
            int num = entry.getValue();

            union.put(word, num);

            if(!map2.containsKey(word))
                continue;

            intersectionSize += Math.min(num, map2.get(word));
        }

        for(Entry<String, Integer> entry: map2.entrySet()) {
            String word = entry.getKey();
            int num = entry.getValue();

            if(union.getOrDefault(word, 0)>=num)
                continue;

            union.put(word, num);
        }

        for(int num: union.values())
            unionSize += num;


        return unionSize==0 ? 65536 : intersectionSize*65536/unionSize;
    }

    private boolean areEnglishLetters(String str) {
        if(str.charAt(0)>='A' && str.charAt(0)<='Z' && str.charAt(1)>='A' && str.charAt(1)<='Z')
            return true;
        return false;
    }

    private void addWords(Map<String, Integer> map, String str) {
        for(int i=0; i<str.length()-1; i++) {
            String word = str.substring(i, i+2).toUpperCase();
            if(!areEnglishLetters(word))
                continue;

            if(!map.containsKey(word))
                map.put(word, 0);

            map.put(word, map.get(word)+1);
        }
    }
}