package 프로그래머스.레벨2.이진_변환_반복하기;

public class Solution {
    public int[] solution(String s) {
        int removed = 0;
        int cnt = 0;

        while(!s.equals("1")) {
            int n = countOne(s);
            removed += s.length() - n;
            s = toBinary(n);
            cnt++;
        }

        int[] answer = {cnt, removed};
        return answer;
    }

    private String toBinary(int n) {
        StringBuilder sb = new StringBuilder();

        while(n!=0) {
            sb.append(n%2);
            n /= 2;
        }

        return sb.reverse().toString();
    }

    private int countOne(String s) {
        int cnt = 0;

        for(char c: s.toCharArray()) {
            if(c=='1')
                cnt++;
        }

        return cnt;
    }
}