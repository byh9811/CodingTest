package 백준.골드5.뱀과_사다리_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> ladder = new HashMap<>();
        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] cnt = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int location = q.poll();
            if(location==100)
                break;

            for(int i=1; i<=6; i++) {
                int next = location + i;
                if(next>100 || cnt[next]!=0)
                    continue;

                if(ladder.containsKey(next)) {
                    if(cnt[ladder.get(next)]==0) {
                        q.add(ladder.get(next));
                        cnt[ladder.get(next)] = cnt[location] + 1;
                    }
                } else {
                    q.add(next);
                    cnt[next] = cnt[location] + 1;
                }
            }
        }

        System.out.println(cnt[100]);
    }
}