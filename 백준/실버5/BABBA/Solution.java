package 백준.실버5.BABBA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        for(int i=0; i<K; i++) {
            int temp = a;
            a = b;
            b += temp;
        }

        System.out.print(a + " " + b);
    }
}