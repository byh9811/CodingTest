package 프로그래머스.레벨2.캐시;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0)
            return cities.length * 5;

        Queue<String> cache = new LinkedList<>();
        int answer = 0;

        for(String city: cities) {
            String upperCity = city.toUpperCase();
            if(cache.contains(upperCity)) {
                answer += 1;

                if(cache.size()==cacheSize) {
                    Queue<String> tempQ = new LinkedList<>();

                    while(!cache.isEmpty()) {
                        String elem = cache.poll();
                        if(!elem.equals(upperCity))
                            tempQ.add(elem);
                    }

                    while(!tempQ.isEmpty())
                        cache.add(tempQ.poll());
                }

                cache.add(upperCity);
            } else {
                answer += 5;

                if(cache.size()==cacheSize)
                    cache.poll();

                cache.add(upperCity);
            }
        }

        return answer;
    }
}