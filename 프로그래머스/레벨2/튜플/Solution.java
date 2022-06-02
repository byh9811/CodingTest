package 프로그래머스.레벨2.튜플;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(String s) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<s.length()-1; i+=2) {
            char c = s.charAt(i);
            ArrayList<Integer> arr = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while(c!='}') {
                c = s.charAt(++i);
                if(c>='0' && c<='9') {
                    sb.append(c-'0');
                } else {
                    arr.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            map.put(arr.size(), arr);
        }

        int[] answer = new int[map.size()];
        for(int i=1; i<map.size()+1; i++) {
            ArrayList<Integer> arr = map.get(i);
            for(int elem: arr) {
                if(set.contains(elem))
                    continue;
                answer[i-1] = elem;
                set.add(elem);
                break;
            }
        }

        return answer;
    }
}