package 백준.골드5.AC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for(int j=0; j<n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            int head = 0;
            int tail = n-1;
            boolean reverse = false;

            for(int j=0; j<p.length(); j++) {
                if(p.charAt(j)=='D') {
                    if(reverse)
                        tail--;
                    else
                        head++;
                }
                else
                    reverse = reverse ^ true;
            }

            if(head<tail+1) {
                StringBuilder sb = new StringBuilder("[");
                if(reverse) {
                    for(int j=tail; j>=head; j--)
                        sb.append(arr[j]).append(',');
                } else {
                    for(int j=head; j<=tail; j++)
                        sb.append(arr[j]).append(',');
                }
                System.out.println(sb.deleteCharAt(sb.length()-1).append(']'));
            } else if(head==tail+1)
                System.out.println("[]");
            else
                System.out.println("error");
        }
    }
}