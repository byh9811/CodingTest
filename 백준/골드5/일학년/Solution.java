package 백준.골드5.일학년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    long answer = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(arr, 0, 0);
        System.out.print(answer);
    }

    private void dfs(int[] arr, int depth, int sum) {
        if(sum>20 || sum<0) {
            return;
        }
        if(depth==arr.length-1) {
            if(sum==arr[arr.length-1])
                answer++;
            return;
        }

        for(int i=depth; i<arr.length-1; i++) {
            dfs(arr, depth+1, sum+arr[i]);
            dfs(arr, depth+1, sum-arr[i]);
        }
    }
}