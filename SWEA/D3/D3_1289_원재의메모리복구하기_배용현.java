package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. 반복문으로 풀 수 있을 것 같은데 재귀를 사용해보자.
 * 2. 문자열을 불린 배열로 바꿔 저장 효율을 좋게 한다.
 * 3. 한문자씩 검사하며 다른 문자가 나올 때마다 answer를 더해준다.
 *
 * @author 배용현
 *
 */
public class D3_1289_원재의메모리복구하기_배용현 {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            answer = 0;
            String input = br.readLine();
            boolean[] str = new boolean[input.length()];
            for(int j=0; j<input.length(); j++) {
                str[j] = input.charAt(j) == '1';
            }
            recur(str, 0, false);
            System.out.printf("#%d %d\n", i, answer);
        }
    }

    private static void recur(boolean[] str, int idx, boolean prev) {
        if(idx>=str.length) {
            return;
        }

        if(str[idx]!=prev) {
            answer++;
            prev = !prev;
        }

        recur(str, idx+1, prev);
    }
}
