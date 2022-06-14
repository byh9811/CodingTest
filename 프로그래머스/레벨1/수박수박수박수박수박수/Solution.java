package 프로그래머스.레벨1.수박수박수박수박수박수;

public class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++)
            sb.append((i&1)==1 ? "수" : "박");

        return sb.toString();
    }
}