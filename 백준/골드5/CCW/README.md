# CCW

### 문제 설명

2차원 좌표 평면 위에 있는 점 3개 P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>가 주어진다. P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>를 순서대로 이은 선분이 어떤 방향을 이루고 있는지 구하는 프로그램을 작성하시오.

-----------
### 입력

첫째 줄에 P<sub>1</sub>의 (x<sub>1</sub>, y<sub>1</sub>), 둘째 줄에 P<sub>2</sub>의 (x<sub>2</sub>, y<sub>2</sub>), 셋째 줄에 P<sub>3</sub>의 (x<sub>3</sub>, y<sub>3</sub>)가 주어진다. (-10,000 ≤ x<sub>1</sub>, y<sub>1</sub>, x<sub>2</sub>, y<sub>2</sub>, x<sub>3</sub>, y<sub>3</sub> ≤ 10,000) 모든 좌표는 정수이다. P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>의 좌표는 서로 다르다.

-----------
### 출력

P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>를 순서대로 이은 선분이 반시계 방향을 나타내면 1, 시계 방향이면 -1, 일직선이면 0을 출력한다.

-----------
### URL

https://www.acmicpc.net/problem/11758

-----------
## 풀이
1. CCW는 Counter Clockwise의 약자로, 평면 위 놓여진 세 점의 방향 관계를 구하는 알고리즘이다.
2. 신발끈 공식을 이용해서 나온 수가 양수이면 반시계방향, 음수이면 시계방향, 0이면 직선이다.
3. 기하와 벡터 알고리즘이기 때문에 공부를 더 해야할 것 같다.

- 출처: https://degurii.tistory.com/47