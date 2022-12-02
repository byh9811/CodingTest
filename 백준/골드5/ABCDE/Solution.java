package 백준.골드5.ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    boolean exist = false;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] friends = new ArrayList[N];
        boolean[] visited = new boolean[N];

        for(int i=0; i<N; i++)
            friends[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        for(int i=0; i<N; i++) {
            if(exist)
                break;

            visited[i] = true;
            dfs(0, i, visited, friends);
            visited[i] = false;
        }

        System.out.println(exist ? 1 : 0);
    }

    private void dfs(int depth, int person, boolean[] visited, ArrayList<Integer>[] friends) {
        if(depth==4) {
            exist = true;
            return;
        }

        for(int friend: friends[person]) {
            if(visited[friend])
                continue;

            visited[friend] = true;
            dfs(depth+1, friend, visited, friends);
            visited[friend] = false;
        }
    }
}