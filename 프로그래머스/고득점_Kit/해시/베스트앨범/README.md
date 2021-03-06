# 베스트앨범

### 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

-----------
### 제한 사항

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

-----------
### 입출력 예

| genres                                          | plays                      | return       |
|-------------------------------------------------|----------------------------|--------------|
| ["classic", "pop", "classic", "classic", "pop"] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42579

-----------
## 풀이
1. 장르와 총 플레이 수를 저장할 클래스 `Plays`를 정의하고 플레이 수로 정렬할 수 있게 한다.
2. `Plays`를 저장할 우선순위 큐 `pq`를 역순으로 생성한다.
3. 장르별 총 플레이 수를 저장할 해시맵 `totalPlay`를 생성한다.
4. `genres`를 순회하면서 `totalPlay`를 초기화하고, 종료되면 각 장르를 `Plays`로 변환하여 `pq`에 삽입한다.
5. `pq`에서 원소를 반복하여 poll하면서 두 곡을 뽑는다.
   1. `max`를 -1로 초기화하고 `genres`를 순회하며 poll한 장르에서 가장 많이 플레이된 곡의 `index`와 플레이 수를 저장한다.
   2. 순회한 뒤 `index`가 -1이 아닐 경우 인덱스를 `answer`에 저장하고 해당 `index`의 플레이 수를 -1로 만든다.
   3. 한 번 더 순회하며 1~2번을 수행한다.
6. 5번이 종료되면 `answer`를 리턴한다.