package 프로그래머스.레벨1.짝수와_홀수;

public class Solution {
    public String solution(int num) {
        return (num&1)==1 ? "Odd" : "Even";
    }
}