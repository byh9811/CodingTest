package 백준.골드5.치킨_배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 *
 * 1. 치킨집을 어디를 폐업시킬지 골라낸다. (조합)
 *   - 몇번째 치킨집을 살릴건지 치킨집의 개수를 크기로 가지는 배열로 만들고, 순회할때 인덱스를 계산해서 폐업시킨 치킨집은 건너뛴다.
 *   - 위의 과정을 통해 폐업한 치킨집을 0으로 바꾼 맵을 새로 만든다.
 *   - 조합을 완성했을 때 만든 맵을 이용해 bfs수행 로직을 넣으면 될 것 같다.
 * 2. 폐업이 진행된 마을에서 각 집의 치킨거리를 구한다.
 * 3. 가장 작은 도시의 치킨 거리를 저장한다.
 * 4. 치킨거리를 구하는 도중에 저장된 도시의 치킨 거리를 넘을 경우, 중단하고 1로 넘어간다.
 * 5. 1~4를 모든 경우의 수에 대해 진행한 뒤 저장된 가장 작은 도시의 치킨 거리를 출력한다.
 * 6. 치킨집을 고를 때 O(2^m), bfs를 수행할 때 O(n^2)이 소요된다.
 * 7. n=50, m=13을 대입하면 약 20,000,000으로 백트래킹을 구현하지 않아도 통과할 수 있을 것 같다.
 * -> 메모리 초과 발생 (이유는 모르겠음)
 * ---------------------------------------------
 * 1. 치킨집 어디를 살릴지 조합으로 골라낸다. -> O(2^M)
 * 2. 각 가정집의 치킨거리를 구한다. -> O(NM)
 * 3. 모든 가정집의 치킨거리를 구하면 도시의 치킨거리이고, 이 최솟값을 저장하여 출력한다.
 * 4. O(NM2^M)이므로 각 가정집에서의 치킨거리는 동일한 치킨집이 존재할 때는 변하지 않으므로 미리 계산해두면 효율적이다.
 *
 * @author 배용현
 *
 */
public class Main {
    static int N, M;
    static ArrayList<int[]> stores = new ArrayList<>();
    static ArrayList<int[]> homes = new ArrayList<>();
    static int[][] dist;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            String input = br.readLine();		// 한줄 입력받아서
            for(int j=0; j<N; j++) {
                switch (input.charAt(j*2)) {		// 입력되는 수는 한자리이므로 짝수 인덱스로 접근 가능
                    case '1': homes.add(new int[] {j, i}); break;		// 1은 집에 저장
                    case '2': stores.add(new int[] {j, i}); break;		// 2는 가게에 저장
                }
            }
        }

        dist = new int[stores.size()][homes.size()];		// 각 치킨집에서 가정집까지의 거리
        visited = new boolean[stores.size()];		// 조합 구현을 위한 방문 배열

        for(int i=0; i<stores.size(); i++) {
            for(int j=0; j<homes.size(); j++)		// 각 치킨집에서 집까지의 거리를 미리 계산
                dist[i][j] = Math.abs(stores.get(i)[0]-homes.get(j)[0]) + Math.abs(stores.get(i)[1]-homes.get(j)[1]);
        }

        combination(0, 0);		// 치킨집을 고르는 조합
        System.out.println(answer);
    }

    private static void combination(int idx, int start) {		// 살아남을 치킨집을 구하는 메서드
        if(idx==M) {		// M개 뽑았으면
            int chDis = 0;
            for(int i=0; i<homes.size(); i++) {		// 각 가정집에서
                int minDis = Integer.MAX_VALUE;
                for(int j=0; j<stores.size(); j++) {
                    if(visited[j])		// 뽑은 치킨집까지의 거리의 최솟값을 저장
                        minDis = Math.min(minDis, dist[j][i]);
                }
                chDis += minDis;		// 가정집의 치킨거리 합이 도시의 치킨거리임
            }

            answer = Math.min(answer, chDis);		// 도시의 치킨 거리 업데이트

            return;
        }

        for(int i=start; i<stores.size(); i++) {		// 치킨집을 조합으로 뽑는다.
            visited[i] = true;
            combination(idx+1, i+1);
            visited[i] = false;
        }
    }
}