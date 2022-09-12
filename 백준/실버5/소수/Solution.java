package 백준.실버5.소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]);
        int answer = 0;

        for(int i=-1; i<N; i++) {
            answer = A / B;
            A %= B;
            A *= 10;
        }

        System.out.println(answer);
    }
}