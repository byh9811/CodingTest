package 백준.골드5.두_용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int head = 0;
        int tail = N-1;
        int answer = Integer.MAX_VALUE;
        int big = 0;
        int small = 0;

        while(head<tail) {
            int hValue = arr[head];
            int tValue = arr[tail];
            int dif = Math.abs(hValue+tValue);
            if(answer>dif) {
                answer = dif;
                big = tValue;
                small = hValue;
            }

            if(hValue+tValue<0)
                head++;
            else if(hValue+tValue>0)
                tail--;
            else
                break;
        }

        System.out.println(small + " " + big);
    }
}