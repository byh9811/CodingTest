package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.그리디.구명보트;

public class Solution {
    public int solution(int[] people, int limit) {
        int[] weight = new int[241];
        int answer = 0;
        for(int elem: people)
            weight[elem]++;

        for(int i=40; i<weight.length; i++) {
            if(weight[i]==0)
                continue;
            weight[i]--;
            for(int j=limit-i; j>=i; j--) {
                if(weight[j]==0)
                    continue;
                weight[j]--;
                break;
            }
            if(weight[i]!=0)
                i--;
            answer++;
        }

        return answer;
    }
}