# 문자열 내 p와 y의 개수

### 문제 설명

대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

-----------
### 제한사항

- 문자열 s의 길이 : 50 이하의 자연수
- 문자열 s는 알파벳으로만 이루어져 있습니다.

-----------
### 입출력 예

| expression | answer |
|------------|--------|
| "pPoooyY"  | true   |
| "Pyy"      | false  |

-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/12916

-----------
## 풀이
1. `pNum`과 `yNum`을 0으로 초기화한다.
2. `s`를 한글자씩 순회하면서 소문자로 변환한다.
3. 변환한 문자가 `p`이면 `pNum`을, `y`이면 `yNum`을 1 올린다.
4. `pNum`과 `yNum`이 같으면 `true`를, 다르면 `false`를 리턴한다.