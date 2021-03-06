# 섬 연결하기

### 문제 설명

n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

-----------
### 제한 사항

- 섬의 개수 n은 1 이상 100 이하입니다.
- costs의 길이는 `((n-1) * n) / 2`이하입니다.
- 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
- 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
- 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
- 연결할 수 없는 섬은 주어지지 않습니다.

-----------
### 입출력 예

| n                       | costs                                     | return |
|-------------------------|-------------------------------------------|--------|
| ["leo", "kiki", "eden"] | [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]] | 4      |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42861

-----------
## 풀이
1. 최소비용트리를 구하는 문제이므로 크루스칼 알고리즘을 사용하면 될 것 같다.
2. Union-Find 알고리즘을 이용하여 사이클을 확인해야 한다.
3. 부모 정보를 저장할 int형 배열 `parent[n]`을 생성하고 값과 인덱스가 일치하도록 초기화한다.
4. 최소비용트리를 구해기 위해 `Comparator`를 이용하여 `cost` 기준 오름차순으로 정렬한다.
5. 정렬한 `costs`를 순회하면서 각 노드의 부모가 다른지 검사한다.
6. 부모가 다르다면 해당 `cost`를 `answer`에 저장하고 각 노드를 Union한다.
7. 반복문이 종료되면 `answer`를 리턴한다.