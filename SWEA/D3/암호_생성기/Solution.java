package SWEA.D3.암호_생성기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 암호 생성기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 *
 * 1. 맨 앞의 수를 cnt만큼 빼서 뒤로 넘기는 작업을 큐를 이용해 반복한다.
 * 2. cnt는 5단위로 초기화된다.
 * 3. 뺀 수가 0이하면, 큐에서 순서대로 빼서 출력한다.
 *
 * @author 배용현
 *
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {		// 테스트케이스 반복
            String test_case = br.readLine();		// 테스트케이스가
            if(test_case.isEmpty())		// 주어지지 않으면
                break;		// 탈출

            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++)
                q.add(Integer.parseInt(st.nextToken()));		// 각 숫자 입력
            int cnt = 0;		// cnt는 0으로 시작해야 아래서 1로 맞춰짐

            while(true) {
                cnt = cnt%5+1;		// cnt는 5단위로 초기화됨
                int next = q.poll() - cnt;		// 변환되어 큐에 들어갈 값
                q.add(Math.max(next, 0));		// 큐에넣되 음수면 0으로 넣는다.
                if(next<=0)		// 음수면
                    break;		// 종료
            }

            sb.append('#').append(test_case).append(' ');		// 테스트케이스 출력
            while(!q.isEmpty())		// 큐에 있는 원소 전부 출력
                sb.append(q.poll()).append(' ');		// 띄어쓰기로 구분
            sb.append('\n');		// 테스트케이스 끝나면 줄바꿈
        }

        System.out.println(sb);		// 저장된 문자열 전부 출력
    }
}
