package 프로그래머스.레벨2.k진수에서_소수_개수_구하기;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertedN = convert(n, k);
        int startIdx = 0;

        while(startIdx<convertedN.length()) {
            int endIdx = startIdx;

            while(endIdx<convertedN.length() && convertedN.charAt(endIdx)!='0')
                endIdx++;

            if(startIdx!=endIdx)
                answer += isPrime(Long.parseLong(convertedN.substring(startIdx, endIdx))) ? 1 : 0;

            startIdx = endIdx+1;
        }

        return answer;
    }

    private boolean isPrime(long num) {
        for(long i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }

        return num==1 ? false : true;
    }

    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while(n!=0) {
            sb.append(n%k);
            n /= k;
        }

        return sb.reverse().toString();
    }
}