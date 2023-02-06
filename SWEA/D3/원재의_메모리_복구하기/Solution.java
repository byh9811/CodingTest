package SWEA.D3.원재의_메모리_복구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 원재의 메모리 복구하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
 *
 * 1. 반복문으로 풀 수 있을 것 같은데 재귀를 사용해보자.
 * 2. 문자열을 불린 배열로 바꿔 저장 효율을 좋게 한다.
 * 3. 한문자씩 검사하며 다른 문자가 나올 때마다 answer를 더해준다.
 *
 * @author 배용현
 *
 */
public class Solution {
    static int answer;      // 수정 횟수를 기록하기 위한 변수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {       // 테스트케이스만큼 반복
            answer = 0;
            String input = br.readLine();
            boolean[] str = new boolean[input.length()];        // 받은 문자열의 길이만큼 불린 타입 배열 생성
            for(int j=0; j<input.length(); j++) {       // 문자열을 불린 배열으로 변경
                str[j] = input.charAt(j) == '1';
            }
            recur(str, 0, false);       // 재귀 함수를 호출해 answer 계산
            System.out.printf("#%d %d\n", i, answer);       // 형식에 맞게 출력
        }
    }

    private static void recur(boolean[] str, int idx, boolean prev) {
        if(idx>=str.length) {       // 더이상 접근할 문자가 남지 않았으면 종료
            return;
        }

        if(str[idx]!=prev) {        // 현재 문자가 이전 문자와 다르다면
            answer++;       // bit를 변경해야함
            prev = !prev;       // 이후에 또 변경해야 할 때를 저장해 놔야하기 때문에 현재 값으로 prev 업데이트
        }

        recur(str, idx+1, prev);        // 남은 문자열에 대해 재귀 호출
    }
}
