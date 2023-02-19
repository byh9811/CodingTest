package 백준.실버4.설탕배달;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 * 
 * 1. 설탕을 5kg 봉지로 담을 수 있는 만큼 담는다.
 * 2. 남은 설탕을 3kg 봉지로 담는다.
 * 3. 3kg 봉지로 전부 담아지면 성공 담은 봉지 수를 출력한다.
 * 4. 3kg 봉지로 1kg는 담을 수 없어도 6kg는 담을 수 있는 것처럼 가능성을 확인하기 위해 5kg 봉지를 뜯어서 다시 계산해본다.
 * 5. 원래 양까지 뜯으며 확인하다가 담을 수 없으면 -1을 출력한다.
 * 
 * @author 배용현
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());

        for(int i = total/5; i >= 0; i--) {		// i는 봉지 수
            if((total - (5*i)) % 3 == 0){		// 남은 양이 3kg에 담기면
                System.out.println(i + ((total - (5*i)) / 3));		// 5kg 봉지 수 + 3kg 봉지 수
                return;
            }
        }

        System.out.println(-1);
    }
}