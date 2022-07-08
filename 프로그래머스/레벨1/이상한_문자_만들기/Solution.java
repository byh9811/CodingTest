package 프로그래머스.레벨1.이상한_문자_만들기;

public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i, i+1);
            answer.append((idx&1)==1 ? str.toLowerCase() : str.toUpperCase());
            idx = str.equals(" ") ? 0 : idx+1;
        }

        return answer.toString();
    }
}