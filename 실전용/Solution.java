package 실전용;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] tasks) {
        HashMap<Integer, Integer> nums = new HashMap<>();

        for(int task: tasks) {
            nums.put(task, nums.get(task)+1);
        }

        return -1;
    }
}