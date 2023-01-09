package SWEA.D2.최빈수_구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
* 1. 점수는 최대 100점이므로 크기가 100인 int형 배열에 나온 횟수를 저장한다.
* 2. 배열을 순회하면서 가장 큰 빈도수를 가지는 인덱스를 형식에 맞게 출력한다.
* 3. 같은 빈도수일 때는 큰 수를 출력해야 한다는 점에 유의한다.
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int test_case = Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                arr[Integer.parseInt(st.nextToken())]++;

            int max = 0;
            int answer = 0;
            for(int i=0; i<101; i++) {
                if(max<=arr[i]) {
                    answer = i;
                    max = arr[i];
                }
            }

            bw.write("#");
            bw.write(String.valueOf(test_case));
            bw.write(" ");
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}