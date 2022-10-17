package 백준.실버5.카드1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++)
            q.add(i);

        StringBuilder sb = new StringBuilder();
        while(q.size()>1) {
            sb.append(q.poll()).append(' ');
            q.add(q.poll());
        }

        sb.append(q.poll());
        System.out.print(sb);
    }
}