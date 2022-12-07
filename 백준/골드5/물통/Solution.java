package 백준.골드5.물통;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    int A, B, C;
    boolean[][] visited;
    Set<Integer> answer = new TreeSet<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A+1][B+1];

        recur(0, 0, C);

        StringBuilder sb = new StringBuilder();
        for(int elem: answer)
            sb.append(elem).append(' ');

        System.out.println(sb);
    }

    private void recur(int a, int b, int c) {
        if(visited[a][b])
            return;

        if(a==0)
            answer.add(c);

        visited[a][b] = true;

        if(a+b>A)
            recur(A, a+b-A, c);
        else
            recur(a+b, 0, c);

        if(a+c>A)
            recur(A, b, a+c-A);
        else
            recur(a+c, b, 0);

        if(a+b>B)
            recur(a+b-B, B, c);
        else
            recur(0, a+b, c);

        if(b+c>B)
            recur(a, B, b+c-B);
        else
            recur(a, b+c, 0);

        recur(a, 0, b+c);
        recur(0, b, a+c);
    }
}