package 프로그래머스.레벨2.마법의_엘리베이터;

import java.util.*;

/*
1. 시작 층은 최대 1억이므로 1억이라면 무조건 내리는게 이득이다.
2. 그 이전 층까지는 최대 자리수가 8이므로 각 자리수에 대해 올리는게 나을지 내리는게 나을지 경우의 수를 계산해볼 수 있다.
3. 일의 자리부터 시작해서 각 경우를 현재 층수와 누른 버튼 수를 기록하며 탐색한다.
4. dfs로 구현하여 최소로 누른 버튼 수를 리턴하면 되지 않을까 싶다.

풀이 시간: 50분 3초
*/
class Solution {
    private int maxIdx = 1;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        for(int i=1; i<=storey; i*=10) {        // 최대 자리수 계산
            maxIdx++;
        }
        
        dfs(0, storey, 0);
        return answer;
    }
    
    private void dfs(int idx, int curStorey, int pressed) {
        if(idx==maxIdx) {
            answer = Math.min(answer, pressed);
            return;
        }
        
        int nod = (int)Math.pow(10, idx+1);     // 자리수
        
        // 내리는 경우
        int nextStorey = (curStorey / nod) * nod;       // 내린 층수
        dfs(idx+1, nextStorey, pressed+(Math.abs(curStorey-nextStorey)/(nod/10)));
        
        // 올리는 경우
        nextStorey += nod;      // 올린 층수
        dfs(idx+1, nextStorey, pressed+(Math.abs(curStorey-nextStorey)/(nod/10)));
    }
}