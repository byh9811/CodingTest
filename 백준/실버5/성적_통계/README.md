# 성적 통계

### 문제 설명

한상덕은 이번에 중덕 고등학교에 새로 부임한 교장 선생님이다. 교장 선생님으로서 첫 번째 일은 각 반의 수학 시험 성적의 통계를 내는 일이다.

중덕 고등학교 각 반의 학생들의 수학 시험 성적이 주어졌을 때, 최대 점수, 최소 점수, 점수 차이를 구하는 프로그램을 작성하시오.

-----------
### 입력

첫째 줄에 중덕 고등학교에 있는 반의 수 K (1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 각 반의 학생수 N (2 ≤ N ≤ 50)과 각 학생의 수학 성적이 주어진다. 시험 성적은 0보다 크거나 같고, 100보다 작거나 같은 정수이고, 공백으로 나누어져 있다.

-----------
### 출력

각 반에 대한 출력은 다음과 같이 두 줄로 이루어져 있다.

- 첫째 줄에는 "Class X"를 출력한다. X는 반의 번호이며 입력으로 주어진 순서대로 1부터 증가한다.
- 둘째 줄에는 가장 높은 점수, 낮은 점수, 성적을 내림차순으로 정렬했을 때 가장 큰 인접한 점수 차이를 예제 출력과 같은 형식으로 출력한다.

-----------
### URL

https://www.acmicpc.net/problem/5800

-----------
## 풀이
1. 1부터 `K`까지 순회하며 각각의 입력을 바로 처리한다.
   1. `N`개의 성적을 입력받고 배열에 저장한다.
   2. 배열을 정렬하고 순회하며 `Largest gap`을 계산한다.
   3. `Max`, `Min`, `Largest gap`을 주어진 형식대로 출력한다.