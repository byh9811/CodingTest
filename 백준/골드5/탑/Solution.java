package 백준.골드5.탑;

import java.io.*;
import java.util.*;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            top[i] = Integer.parseInt(st.nextToken());
        int[] answer = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--) {
            int cur = top[i];
            while(!stack.isEmpty() && cur>=top[stack.peek()]) {
                int notReceivedIdx = stack.pop();
                answer[notReceivedIdx] = i+1;
            }
            stack.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int elem: answer)
            sb.append(elem).append(' ');
        System.out.println(sb);
    }
}