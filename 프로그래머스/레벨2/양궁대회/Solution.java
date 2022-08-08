package 프로그래머스.레벨2.양궁대회;

public class Solution {
    int[] ryanInfo = new int[11];
    int[] answer = {-1};
    int max = -1;

    public int[] solution(int n, int[] info) {
        recur(0, n, info);
        return answer;
    }

    private void recur(int idx, int maxIdx, int[] apeachInfo) {
        if(idx==maxIdx) {
            int ryanScore = 0;
            int apeachScore = 0;

            for(int i=0; i<11; i++) {
                if(apeachInfo[i]!=0 || ryanInfo[i]!=0) {
                    if(ryanInfo[i]>apeachInfo[i])
                        ryanScore += 10-i;
                    else
                        apeachScore += 10-i;
                }
            }

            if(ryanScore>apeachScore && ryanScore-apeachScore>=max) {
                answer = ryanInfo.clone();
                max = ryanScore-apeachScore;
            }

            return;
        }

        for(int i=0; i<11 && ryanInfo[i]<=apeachInfo[i]; i++) {
            ryanInfo[i]++;
            recur(idx+1, maxIdx, apeachInfo);
            ryanInfo[i]--;
        }
    }
}