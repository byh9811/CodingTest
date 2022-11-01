package 백준.실버5.Base_Conversion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = 0;
        for(int i=0; i<m; i++)
            num += Math.pow(A, m-i-1) * arr[i];

        Stack<Integer> stack = new Stack<>();
        while (num!=0) {
            stack.add(num%B);
            num /= B;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty())
            sb.append(stack.pop()).append(' ');

        System.out.print(sb);
    }
}