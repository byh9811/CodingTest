package 프로그래머스.레벨1.두_개_뽑아서_더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++)
                set.add(numbers[i]+numbers[j]);
        }

        int[] answer = Arrays.stream(set.toArray()).mapToInt(i->(int)i).toArray();
        Arrays.sort(answer);

        return answer;
    }
}