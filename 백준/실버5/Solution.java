package 백준.실버5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);

            System.out.println(factorial(M));
            System.out.println(factorial(N));
            System.out.println(factorial(M-N));
        }
    }

    public long factorial(int num) {
        if(num==0)
            return 1;

        return num * factorial(num-1);
    }
}