# 소수 찾기

### 문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

-----------
### 제한 사항

- numbers는 길이 1 이상 7 이하인 문자열입니다.
- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
- "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

-----------
### 입출력 예

| numbers | return |
|---------|--------|
| "17"    | 3      |
| "011"   | 2      |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42839

-----------
## 풀이
1. 숫자를 조합하여 순열을 만드는 기능과 완성된 숫자가 소수인지 판별하는 기능을 만들어야 한다.
2. 완성된 숫자 문자열을 저장할 `set`을 생성한다.
3. `permutation`함수를 만들어 순열을 만드는 기능을 구현한다.
   1. 이전 문자열을 저장하는 `prefix`와 선택 가능한 문자열을 저장하는 `numbers`를 매개변수로 받는다.
   2. `numbers`를 순회하면서 `prefix`에 붙이고 `numbers`를 갱신한 뒤 `permutation`을 재귀호출한다.
   3. `prefix`가 공백이 아니면 `set`에 추가한다.
4. `isPrime`함수를 만들어 소수인지 판별하는 기능을 구현한다.
   1. `permutation`으로 완성된 수를 매개변수 `num`으로 받는다.
   2. `num`이 0이거나 1이면 소수가 아니므로 `false`를 리턴한다.
   3. 2부터 루트 `num`까지 순회하며 `num`이 나누어 떨어지는지 확인한다.
   4. 나누어 떨어지면 `false`로 리턴하며, 끝까지 나누어 떨어지지 않을 경우 `true`를 리턴한다.
5. `permutation`으로 만들어질 수 있는 모든 순열을 `set`에 저장한다.
6. `set`에 저장된 수를 `isPrime`으로 검증하고, 맞다면 `answer`를 1더한다.
7. `set`의 모든 수에 대한 검증이 끝나면 `answer`를 리턴한다.