package 프로그래머스.레벨1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);
        return set.size()>nums.length/2 ? nums.length/2 : set.size();
    }
}