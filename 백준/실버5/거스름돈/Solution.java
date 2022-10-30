package 백준.실버5.거스름돈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1 || n==3) {
            System.out.print(-1);
            return;
        }
        int five = n / 5;
        int two = 0;

        int remain = n % 5;
        switch (remain) {
            case 1: five--; two = 3; break;
            case 2: two = 1; break;
            case 3: five--; two = 4; break;
            case 4: two = 2; break;
        }

        System.out.print(five+two);
    }
}