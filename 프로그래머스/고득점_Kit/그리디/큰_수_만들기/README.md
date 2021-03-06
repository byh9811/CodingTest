# 큰 수 만들기

### 문제 설명

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

-----------
### 제한 사항

- number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
- k는 1 이상 number의 자릿수 미만인 자연수입니다.

-----------
### 입출력 예

| number       | k    | return   |
|--------------|------|----------|
| "1924"       | 30   | "94"     |
| "1231234"    | 3    | "3234"   |
| "4177252841" | 4	   | "775841" |
-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42883

-----------
## 풀이
1. number.length() - k 만큼의 문자열을 생성해야한다.
2. 순서를 바꿀 수 없으므로 한 숫자를 선택했을 때, 뒤에는 반드시 리턴할 수 있는 만큼 숫자가 남아있어야 한다.
3. 2번 과정으로 한 숫자를 선택했을 때, 앞의 숫자는 더이상 볼 필요가 없다.
4. 2번과 3번의 조건을 만족하는 범위에서 모든 숫자를 선택할 때까지 반복한다.