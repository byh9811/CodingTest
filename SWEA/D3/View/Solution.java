package SWEA.D3.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*
 * 1. 일차원 배열로 층수를 저장한다.
 * 2. 배열을 순회하면서 양 옆의 2개의 건물보다 얼마나 높은지 계산하고 그 결과만큼 정답에 더한다.
 * 3. 정답에 값이 더해졌으면 앞으로 두 칸은 조망권이 없으므로 건너뛴다.
 */
public class Solution {
    static char[] num;
    static int cnt;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = 0;

            for(int i=2; i<N-2; i++) {		// 양 옆의 2칸은 빈칸이므로 접근하지 않음
                int min = Math.min(difLeft(arr, i), difRight(arr, i));
                if(min>0) {		// 조망권이 확보된 경우
                    answer += min;		// 정답에 기록하고
                    i += 2;				// 두 칸 건너뛰기
                }
            }

            System.out.printf("#%d %d\n", t, answer);
        }
        br.close();
    }

    // 왼쪽 조망권 확보량
    private static int difLeft(int[] arr, int idx) {
        int ret = Integer.MAX_VALUE;		// 최소를 저장하기 위해 최대로 초기화

        for(int i=1; i<3; i++) {		// 왼쪽 두 칸에 접근
            int dif = arr[idx] - arr[idx-i];		// 현재 빌딩이 왼쪽 빌딩보다 몇칸 위인지
            if(ret>dif)			// 조망은 가장 작은 차이를 저장
                ret = dif;
        }

        return ret;
    }

    // 오른쪽 조망권 확보량
    private static int difRight(int[] arr, int idx) {
        int ret = Integer.MAX_VALUE;		// 최소를 저장하기 위해 최대로 초기화

        for(int i=1; i<3; i++) {		// 오른쪽 두 칸에 접근
            int dif = arr[idx] - arr[idx+i];		// 현재 빌딩이 오른쪽 빌딩보다 몇칸 위인지
            if(ret>dif)			// 조망은 가장 작은 차이를 저장
                ret = dif;
        }

        return ret;
    }
}

