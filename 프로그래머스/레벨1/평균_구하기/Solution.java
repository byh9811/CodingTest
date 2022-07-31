package 프로그래머스.레벨1.평균_구하기;

public class Solution {
    public double solution(int[] arr) {
        double sum = 0.0;

        for(int elem: arr)
            sum += elem;

        return sum/arr.length;
    }
}