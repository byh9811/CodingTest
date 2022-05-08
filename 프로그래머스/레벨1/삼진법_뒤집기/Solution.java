package 프로그래머스.레벨1.삼진법_뒤집기;

public class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>2) {
            sb.append(n%3);
            n /= 3;
        }
        if(n!=0)
            sb.append(n);
        String thirdNum = sb.toString();
        int answer = 0;
        for(int i=0; i<thirdNum.length(); i++) {
            int num = thirdNum.charAt(i)-'0';
            answer += Math.pow(3, sb.length()-1-i) * num;
        }

        return answer;
    }
}