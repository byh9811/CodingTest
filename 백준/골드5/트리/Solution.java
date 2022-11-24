package 백준.골드5.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int answer = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N];
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i]==-1)
                root = i;
        }
        int delete = Integer.parseInt(br.readLine());
        if(root==delete) {
            System.out.println(0);
            return;
        }
        deleteNode(parent, delete);
        countLeaf(parent, root);
        System.out.println(answer);
    }

    private void countLeaf(int[] parent, int cur) {
        boolean hasChild = false;
        for(int i=0; i<parent.length; i++) {
            if(parent[i]==cur) {
                countLeaf(parent, i);
                hasChild = true;
            }
        }
        if(!hasChild)
            answer++;
    }

    private void deleteNode(int[] parent, int delete) {
        parent[delete] = -2;
        for(int i=0; i<parent.length; i++) {
            if(parent[i]==delete)
                deleteNode(parent, i);
        }
    }
}