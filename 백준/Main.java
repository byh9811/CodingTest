package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 제목
 * 문제 URL
 *
 * 1. 문제 풀이에 들어가기 전 생각의 흐름을 이와 같이 적는다.
 * 2. 모든 줄에는 주석을 달아놓는다.
 * 3. 메인 메서드는 입력, 로직, 출력부로 나눈다.
 * 4. 기능을 여러 메서드로 구현해야 한다면 잘게 쪼개서 한 메서드가 한 기능만을 구현하도록 만든다.
 */
public class Main {
    // 공통으로 사용될 것 같은 변수는 static 멤버변수로 작성한다.

    public static void main(String[] args) throws Exception {
        // 입력 처리 & 지역 변수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        // 로직 구현
        for(int i=1; i<=n; i++) {
            sum += i;
        }

        // 출력 처리
        System.out.println(sum);
    }
}
