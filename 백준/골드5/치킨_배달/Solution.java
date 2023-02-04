package 백준.골드5.치킨_배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 약 2시간 30분 소요 - 조합을 구현하는 데 너무 오래걸림
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
*/
class Point {
    int x;
    int y;
    int d;

    public Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Solution {
    static int N, M;
    static int[][] mapOrigin;
    static boolean[] isAlive;
    static int storeNum = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mapOrigin = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                mapOrigin[i][j] = Integer.parseInt(st.nextToken());
                if(mapOrigin[i][j]==2)
                    storeNum++;
            }
        }

        isAlive = new boolean[storeNum];
        combination(0, M);
        System.out.println(answer);
    }

    private static void combination(int idx, int remain) {
        if(remain==0) {
            checkCityChickenDistance();
            return;
        }

        for(int i=idx; i<storeNum; i++) {
            if(!isAlive[i]) {
                isAlive[i] = true;
                combination(idx+1, remain-1);
                isAlive[i] = false;
            }
        }
    }

    private static void checkCityChickenDistance() {
        int cityChickenDistance = 0;

        int[][] map = setMap();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1) {
                    int distance = bfs(map, i, j);
                    if(distance>0)
                        cityChickenDistance += distance;
                }
                if(cityChickenDistance>=answer)
                    break;
            }
        }

        if(cityChickenDistance<answer)
            answer = cityChickenDistance;
    }

    private static int[][] setMap() {
        int[][] map = new int[N][N];
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = mapOrigin[i][j];
                if(map[i][j]==2 && !isAlive[cnt++]) {
                    map[i][j] = 0;
                }
            }
        }
        return map;
    }

    private static int bfs(int[][] map, int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            if(map[p.y][p.x]==2) {
                return p.d;
            }

            if(p.x!=0) {
                q.add(new Point(p.x-1, p.y, p.d+1));
            }

            if(p.x!=N-1) {
                q.add(new Point(p.x+1, p.y, p.d+1));
            }

            if(p.y!=0) {
                q.add(new Point(p.x, p.y-1, p.d+1));
            }

            if(p.y!=N-1) {
                q.add(new Point(p.x, p.y+1, p.d+1));
            }
        }

        return -1;
    }
}