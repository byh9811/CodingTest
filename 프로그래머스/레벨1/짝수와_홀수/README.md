# 홀수와 짝수

### 문제 설명

정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

-----------
### 제한 사항

- num은 int 범위의 정수입니다.
- 0은 짝수입니다.

-----------
### 입출력 예

| num | result |
|-----|--------|
| 3   | "Odd"  |
| 4   | "Even" |

-----------
### URL

https://school.programmers.co.kr/learn/courses/30/lessons/12937

-----------
## 풀이
1. `num`과 1을 `&연산`한 값이 1이면 `Odd`를 리턴하고 아니면 `Even`을 리턴한다.