# 이중우선순위큐

### 문제 설명

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

| 명령어  | 수신 탑(높이)          |
|------|-------------------|
| I 숫자 | 큐에 주어진 숫자를 삽입합니다. |
| D 1  | 큐에서 최댓값을 삭제합니다.   |
| D -1 | 큐에서 최솟값을 삭제합니다.   |

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

-----------
### 제한 사항

- operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
- operations의 원소는 큐가 수행할 연산을 나타냅니다.
  - 원소는 “명령어 데이터” 형식으로 주어집니다.
  - 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

-----------
### 입출력 예

| operations                  | return |
|-----------------------------|--------|
| ["I 16","D 1"]              | [0, 0] |
| ["I 7","I 5","I -5","D -1"] | [7, 5] |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42628

-----------
## 풀이
1. 최대힙과 최소힙을 사용하여 구현한다.
2. 두 힙은 원소를 공유하기 때문에, 삽입과 삭제 연산을 동시에 수행해야 한다.
3. Insert operation이 입력되면 `num`을 두 힙에 모두 넣는다.
4. Delete operation이 입력되면 두 경우에 따라 처리한다.
   1. `num`이 1이면 최대힙에서 poll하고 최소힙에서 삭제한다.
   2. `num`이 -1이면 최소힙에서 poll하고 최대힙에서 삭제한다.
5. 모든 operation에 대해 3~4번 과정이 완료되면 각 힙을 poll한 값을 리턴하되, 비어있다면 0을 리턴한다.