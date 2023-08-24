package 프로그래머스.레벨2.시소_짝궁;

import java.util.*;

/*
1. 한 사람에 대해 다른 한 사람을 고르고 시소 짝궁인지 확인하는 방법은 O(n^2)으로 사용할 수 없다.
2. 사람들을 순회하며 해시맵에 시소 짝궁이 가능한 (무게*거리, 개수)를 기록하는 방법이 있다.
3. 해시맵에 없으면 새로 기록하고, 있으면 개수만큼 정답에 더한다.

풀이 실패 이유
1. hashmap의 키값으로 double형을 주는 것을 생각하지 못함.
2. 1m가 있다고 착각함.
*/
class Solution {
    public long solution(int[] weights) {
        double[] rates = {1.0, 2.0/3, 2.0/4, 3.0/4};
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        for(int weight: weights) {
            for(double rate: rates) {
                double curWeight = weight * rate;
                int num = map.getOrDefault(curWeight, 0);
                answer += num;
            }
            map.put(1.0 * weight, map.getOrDefault(1.0 * weight, 0) + 1);
        }
        
        return answer;
    }
}