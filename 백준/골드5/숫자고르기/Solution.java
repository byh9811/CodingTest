package 백준.골드5.숫자고르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    int[] arr;
    boolean[] visited;
    ArrayList<Integer> answer = new ArrayList<>();
    int start;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine()) - 1;

        for(int i=0; i<N; i++) {
            visited[i] = true;
            start = i;
            dfs(i);
            visited[i] = false;
        }

        answer.sort(null);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for(int elem: answer)
            sb.append(elem+1).append('\n');
        System.out.print(sb);
    }

    private void dfs(int i) {
        if(arr[i]==start)
            answer.add(start);

        if(!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
    }
}