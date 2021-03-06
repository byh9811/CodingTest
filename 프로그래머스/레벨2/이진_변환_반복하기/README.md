# 이진 변환 반복하기

### 문제 설명

0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

1. x의 모든 0을 제거합니다.
2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
예를 들어, `x = "0111010"`이라면, x에 이진 변환을 가하면 `x = "0111010" -> "1111" -> "100"` 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.

-----------
### 제한사항

- s의 길이는 1 이상 150,000 이하입니다.
- s에는 '1'이 최소 하나 이상 포함되어 있습니다.

-----------
### 입출력 예

| s              | result |
|----------------|--------|
| "110010101001" | [3,8]  |
| "01110"        | [3,3]  |
| "1111111"      | [4,1]  |


-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/70129

-----------
## 풀이
1. 반복 횟수를 기록할 변수 `cnt`를 0으로 초기화한다.
2. 제거한 0의 개수를 기록할 변수 `removed`를 0으로 초기화한다.
3. `s`가 "1"이 아니면 다음을 반복한다.
   1. `countOne()`을 실행하여 s에 포함된 1의 개수를 센다.
      1. 문자열 `s`를 매개변수로 받는다.
      2. `cnt`를 0으로 초기화한다.
      3. `s`를 순회하며 1이면 `cnt`에 더한다.
      4. 순회가 끝나면 `cnt`를 리턴한다.
   2. 센 1의 개수를 이용해 `removed`를 갱신하고 `n`을 `toBinary()`를 이용해 이진수로 바꾼다.
      1. 1의 개수 `n`을 매개변수로 받는다.
      2. StringBuilder `sb`를 생성한다.
      3. `n`이 0이 될때까지 다음을 반복한다.
         1. `n`을 2로 나눈 나머지를 `sb`에 더한다.
         2. `n`을 2로 나눈다.
      4. `sb`를 역순 문자열로 바꾼 뒤 리턴한다.
   3. 바꾼 이진수를 `s`에 저장한다.
   4. `cnt`를 1더한다.
4. `cnt`와 `removed`를 배열에 담아 리턴한다.