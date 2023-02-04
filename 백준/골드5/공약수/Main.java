package 백준.골드5.공약수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 공약수
 * https://www.acmicpc.net/problem/3020
 *
 * 1. 두 수의 합이 가장 작으려면 두 수의 차가 가장 작아야함.
 * 2. 최대공약수를 소인수를 모두 가지고 있어야하고, 최소공배수의 소인수 이내로 가지고 있어야함.
 * 3. 최소공배수의 소인수에서 최대공약수의 소인수를 빼고 이들을 곱해서 만들 수 있는 수를 모두 구하고 정렬한다.
 * 4. 중앙에 있는 값 두 개를 최대공약수를 곱해서 출력한다.
 * 5. 최소공배수가 최대 1억이므로 소인수는 최대 30개까지 나올 수 있는데, 이를 조합으로 뽑는 것이 곱해서 만들 수 있는 경우이다.
 * 6. 조합은 O(2^n)이라 1억이라 실패할 것 같다.
 * -------------------------
 * 1. x와 y의 최대공약수 * x와 y의 최소공배수 = x * y
 * 2. 좌변을 a라고 할 때, x = y / a
 * 3. 소인수 집합을 만든다.
 * 4. x는 최대공약수 이상이어야 하므로 소인수집합에서 최대공약수를 이루는 소인수집합을 뺀다.
 * 5. 집합에서 조합을 이용하여
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 처리 & 지역 변수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);     // 동굴의 길이(장애물의 개수) N
        int H = Integer.parseInt(input[1]);     // 동굴의 높이(구간의 개수) H
        int[] top = new int[H+1];       // 종유석의 정보가 들어갈 배열
        int[] bot = new int[H+1];     // 석순의 정보가 들어갈 배열
        for(int i=0; i<N/2; i++) {        // N번의 입력동안 장애물의 정보가 주어진다.
            bot[Integer.parseInt(br.readLine())]++;     // 해당 위치까지 도달하는 석순의 개수를 센다.
            top[H-Integer.parseInt(br.readLine())+1]++;       // 해당 위치까지 도달하는 종유석의 개수를 센다.
        }
        int min = Integer.MAX_VALUE;        // 최솟값을 저장할 변수 min
        int cnt = 0;        // 최솟값을 가지는 구간의 개수를 저장할 cnt

        // 로직 구현
        for(int i=H-1; i>0; i--) {       // 각 구간마다 석순이 몇 개 존재하는지 구한다.
            bot[i] += bot[i+1];     // 석순이 위에 있으면 그 아래는 반드시 석순이 있다.
        }
        for(int i=2; i<=H; i++) {       // 각 구간마다 석순이 몇 개 존재하는지 구한다.
            top[i] += top[i-1];     // 종유석이 아래에 있으면 그 위는 반드시 종유석이 있다.
        }
        for(int i=1; i<=H; i++) {       // 각 구간을 순회하며 장애물의 정보를 확인한다.
            int num = top[i] + bot[i];      // 해당 위치에 존재하는 종유석과 석순을 더한 것이 장애물의 개수이다.
            if(num<min) {       // 현재 구간의 장애물의 수가 현재까지 중 가장 작으면
                min = num;      // 장애물 개수로 최소값을 갱신
                cnt = 1;        // 개수는 1로 갱신
            } else if(num==min) {       // 장애물의 수가 같으면
                cnt++;      // 개수 1추가
            }
        }

        // 출력 처리
        System.out.println(min + " " + cnt);
    }
}
