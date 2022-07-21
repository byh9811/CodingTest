package 프로그래머스.레벨2.N_Queen;

public class Solution {
    int answer = 0;

    public int solution(int n) {
        int[] located = new int[n];
        dp(0, n, located);
        return answer;
    }

    private void dp(int index, int n, int[] located) {
        if(index==n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(isSafe(index, i, located)) {
                located[index] = i;
                dp(index+1, n, located);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] located) {
        for(int i=0; i<row; i++) {
            if(located[i]+i==col+row || located[i]==col || located[i]-i==col-row)
                return false;
        }

        return true;
    }
}