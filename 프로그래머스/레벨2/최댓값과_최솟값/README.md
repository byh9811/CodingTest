# 최댓값과 최솟값

### 문제 설명

문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

-----------
### 제한 사항

- s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

-----------
### 입출력 예

| s             | return  |
|---------------|---------|
| "1 2 3 4"     | "1 4"   |
| "-1 -2 -3 -4" | "-4 -1" |
| "-1 -1"       | "-1 -1" |

-----------
### URL

https://school.programmers.co.kr/learn/courses/30/lessons/12939

-----------
## 풀이
1. `min`과 `max`를 각각 `Integer.MAX_VALUE`와 `Integer.MIN_VALUE`로 초기화한다.
2. `s`를 공백으로 나누어 순회하면서 `min`, `max`와 비교하고 필요시 갱신한다.
3. 순회가 끝나면 `min`과 `max`를 String으로 변환하여 리턴한다.