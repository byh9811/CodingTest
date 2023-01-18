package SWEA.D3.유효숫자_표기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. N이 굉장히 클 수 있으므로 문자열로 다룬다.
 * 2. 세 번째 숫자를 반올림하여 앞의 숫자를 파악한다.
 * 3. 문자열의 길이-1을 지수부로 초기화한다.
 * 4. 2번에서 파악한 숫자가 100이면 지수부를 업데이트한다.
 * 3. 앞의 숫자를 x.x형태로 표현하고 형식에 맞게 출력한다.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {
            String input = br.readLine();
            double num = Math.round(Integer.parseInt(input.substring(0, 3))/10.0);
            int exp = input.length() - 1;
            if(num==100.0) {
                num = 1.0;
                exp++;
            } else {
                num /= 10;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('#').append(t).append(' ').append(num).append('*').append(10).append('^').append(exp).append('\n');
            System.out.print(sb);
        }
    }
}