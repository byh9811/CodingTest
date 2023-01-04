package 프로그래머스.레벨0.배열의_평균값;

public class Solution {
    public double solution(int[] numbers) {
        double sum = 0.0;
        for(int number: numbers)
            sum += number;
        return sum/numbers.length;
    }
}