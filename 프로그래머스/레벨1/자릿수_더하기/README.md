# 자릿수 더하기

### 문제 설명

자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

-----------
### 제한 사항

- N의 범위 : 100,000,000 이하의 자연수

-----------
### 입출력 예

| N   | result |
|-----|--------|
| 123 | 6      |
| 987 | 24     |

-----------
### URL

https://school.programmers.co.kr/learn/courses/30/lessons/12931

-----------
## 풀이
1. `answer`를 0으로 초기화한다.
2. `n`을 10으로나눈 나머지를 `answer`에 더한다.
3. `n`을 10으로 나눈다.
4. 2~3번을 n이 0이 될 때까지 반복한다.
5. `answer`를 리턴한다.