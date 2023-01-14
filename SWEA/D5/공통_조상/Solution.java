package SWEA.D5.공통_조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 1. Union-Find 알고리즘을 이용해 주어진 두 노드의 조상들을 찾는다. O(n)
* 2. 조상을 순회하며 비교하여 가장 가까운 공통 조상을 찾는다. O(n^2)
* 3. 조상을 찾을때와 반대로 접근하여 서브 트리의 크기를 구한다. O(n)
* 4. 총 시간복잡도는 O(V^2)이고 V는 최대 10,000이므로 사용가능하다.
* */
public class Solution {
    int count;
    int[] parent;
    ArrayList<Integer> v1Parents, v2Parents;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            parent = new int[V+1];
            for(int i=0; i<V; i++) {
                parent[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<E; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            v1Parents = new ArrayList<>();
            v2Parents = new ArrayList<>();
            findParents(v1Parents, v1);
            findParents(v2Parents, v2);
            int lcp = findLCP();
            parent[lcp] = 0;
            findChildren(lcp);
            System.out.printf("#%d %d %d\n", test_case, lcp, count);
        }
    }

    private void findChildren(int p) {
        count++;
        for(int i=1; i<parent.length; i++) {
            if(parent[i]==p)
                findChildren(i);
        }
    }

    private int findLCP() {
        for(int v1p: v1Parents) {
            for(int v2p: v2Parents) {
                if(v1p==v2p) {
                    return v1p;
                }
            }
        }

        return -1;
    }

    private void findParents(ArrayList<Integer> parents, int cur) {
        parents.add(cur);
        if(cur!=parent[cur]) {
            findParents(parents, parent[cur]);
        }
    }
}