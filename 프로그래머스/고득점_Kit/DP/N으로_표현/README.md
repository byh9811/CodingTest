# N으로 표현

### 문제 설명

아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

-----------
### 제한 사항

- N은 1 이상 9 이하입니다.
- number는 1 이상 32,000 이하입니다.
- 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
- 최솟값이 8보다 크면 -1을 return 합니다.

-----------
### 입출력 예

| N   | number | return |
|:----|--------|--------|
| 5   | 12     | 4      |

-----------
### URL

https://programmers.co.kr/learn/courses/30/lessons/42895

-----------
## 풀이
1. 재귀 호출로는 괄호를 표현할 수 없기 때문에 재귀 호출을 사용할 수 없다.
2. n개의 N을 사용하여 만들 수 있는 수는 n-1개의 N을 사용하여 만든 수를 붙이거나, 사칙연산을 하여 만들 수 있다.
3. n개의 N을 사용하여 만들 수 있는 수는 Set에 저장하고 이를 저장할 Set배열 sets를 생성한다.
4. 1~8개의 N을 사용하여 만들 수 있는 수를 반복문을 통해 모두 저장한다.
5. 반복문이 종료되면 sets에 저장된 모든 숫자를 확인하고 찾을 경우, 인덱스를 리턴한다.
6. 5번에서 찾지 못할 경우 -1을 리턴한다.