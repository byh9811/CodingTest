package 프로그래머스.레벨2.귤_고르기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/138476
* 1. 해시맵을 이용해 각 원소가 몇 번 등장했는지 저장한다.
* 2. 몇번 등장했는지 기준으로 각 원소를 내림차순 정렬한다.
* 3. 정렬한 리스트를 순회하며 k값만큼 뽑을때 최소 종류의 수를 출력한다.
* */
public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for(int elem: list) {
            answer++;
            k -= map.get(elem);
            if(k<=0)
                break;
        }

        return answer;
    }
}