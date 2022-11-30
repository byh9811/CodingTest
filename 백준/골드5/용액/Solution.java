package 백준.골드5.용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int head = 0;
        int tail = N-1;
        int dif = Integer.MAX_VALUE;
        int min = 0, max = 0;
        while(head<tail) {
            int sum = arr[head] + arr[tail];
            int newDif = Math.abs(sum);
            if(sum>0) {
                if(newDif<dif) {
                    min = arr[head];
                    max = arr[tail];
                    dif = newDif;
                }
                tail--;
            } else if(sum<0) {
                if(newDif<dif) {
                    min = arr[head];
                    max = arr[tail];
                    dif = newDif;
                }
                head++;
            } else {
                min = arr[head];
                max = arr[tail];
                break;
            }
        }

        System.out.print(min + " " + max);
    }
}