package 백준.골드5.강의실_배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        pq.add(classes[0][1]);
        int answer = 1;
        for(int i=1; i<N; i++) {
            while(!pq.isEmpty() && classes[i][0]>=pq.peek())
                pq.poll();

            pq.add(classes[i][1]);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}