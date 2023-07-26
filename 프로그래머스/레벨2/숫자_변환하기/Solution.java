package 프로그래머스.레벨2.숫자_변환하기;

import java.util.*;

/*
1. visited 배열을 이용하여 x로 만든 수를 저장한다.
2. 새롭게 저장된 수만으로 세 연산을 수행하여 다음 수를 만든다.
3. y의 범위를 넘어가면 그 수는 버린다.

풀이 시간: 15분 45초
*/
class Solution {
    public int solution(int x, int y, int n) {
        if(x==y)
            return 0;
        
        boolean[] visited = new boolean[y];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        visited[x] = true;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            cnt++;
            
            for(int t=0; t<size; t++) {
                int cur = q.poll();

                for(int i=0; i<3; i++) {
                    int next = cal(cur, i, n);

                    if(next==y) {
                        return cnt;
                    }
                    
                    if(next<y && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return -1;
    }
               
    private int cal(int x, int i, int n) {
        switch(i) {
            case 0: return x+n;
            case 1: return 2*x;
            default: return 3*x;
        }
    }
}