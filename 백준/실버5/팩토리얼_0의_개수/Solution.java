package 백준.실버5.팩토리얼_0의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N / 125;
        cnt += N / 25;
        cnt += N / 5;

        System.out.println(cnt);
    }
}