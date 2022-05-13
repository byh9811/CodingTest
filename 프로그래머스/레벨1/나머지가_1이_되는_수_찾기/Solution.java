package 프로그래머스.레벨1.나머지가_1이_되는_수_찾기;

public class Solution {
    public int solution(int n) {
        for(int i=2; i<1000000; i++) {
            if(n%i==1)
                return i;
        }
        return -1;
    }
}