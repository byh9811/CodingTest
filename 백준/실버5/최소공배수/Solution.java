package 백준.실버5.최소공배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        long GCD = getGCD(Math.max(A, B), Math.min(A, B));
        System.out.print(A*B/GCD);
    }

    private long getGCD(long big, long small) {
        return big%small==0 ? small : getGCD(small, big%small);
    }
}