package 프로그래머스.레벨1.없는_숫자_더하기;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] nums = new boolean[10];
        for(int number: numbers)
            nums[number] = true;
        for(int i=0; i<nums.length; i++) {
            if(!nums[i])
                answer += i;
        }
        return answer;
    }
}