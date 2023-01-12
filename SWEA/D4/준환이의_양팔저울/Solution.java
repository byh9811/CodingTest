package SWEA.D4.준환이의_양팔저울;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 1. N의 범위가 1~9이므로 완전탐색(순열)을 사용하면 될 것 같다.
* 2. 재귀를 이용해 무게추를 올리고 왼쪽과 오른쪽의 무게를 계산한다.
* 3. 올리는 과정 중 오른쪽의 무게가 더 커지면 리턴해서 백트래킹해야한다.
* 4. depth가 N이 되었을 때 왼쪽과 오른쪽의 무게를 비교해 오른쪽이 작은 경우의 수를 센다.
* */
public class Solution {
    int answer;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[] visited = new boolean[N];
            answer = 0;
            recur(arr, visited, 0, 0, 0);
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private void recur(int[] arr, boolean[] visited, int depth, int left, int right) {
        if(right>left) {
            return;
        } else if(depth==arr.length) {
            answer++;
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            recur(arr, visited, depth+1, left+arr[i], right);
            recur(arr, visited, depth+1, left, right+arr[i]);
            visited[i] = false;
        }
    }
}