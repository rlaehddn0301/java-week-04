java 4주차 레포트
=================

6. 체온 값 36.5로 초기화된 상수 bodytemp를 double형으로 선언하라.
   ```public class Main {
    public static void main(String[] args) {
        final double bodytemp = 36.5; // 체온을 36.5로 초기화한 double형 상수
        System.out.println("체온: " + bodytemp + "℃");
    }
} ```

7. 다음 각 항목의 코드에서 컴파일 오류를 수정하라
  1) while(1) {}
  2) int n = 3.5;
  3) int b = (3<5?ture:false;
  4) int score = 85;
     if(80 < score < 90) System.out.print(score);

``` 풀이 : 
1) while 문의 조건식은 반드시 논리(boolean) 값이어야 한다. 1은 정수이므로 오류가 발생한다. true나 false와 같은 논리 값으로 수정해야 한다.
    수정된 코드: while (true) {}

2) 3.5는 부동 소수점(double 또는 float) 값이다. 이 값을 정수(int) 변수에 직접 할당하면 컴파일 오류가 발생한다.
    수정된 코드: double n = 3.5; 또는 float n = 3.5f;

3) int b = (3<5?ture:false;
  조건 연산자(?)의 형식이 올바르지 않다. true 대신에 true로 수정한다.
    수정된 코드: int b = (3 < 5 ? true : false);

4) int score = 85; if(80 < score < 90) System.out.print(score);
  이 코드는 예상한대로 작동하지 않는다. Java에서는 연속된 비교 연산자를 사용할 수 없다. 올바른 방법은 논리 연산자를 사용하는 것이다.
    수정된 코드: int score = 85; if (score > 80 && score < 90) System.out.print(score);
```

8. 다음 문장을 조건식으로 나타내라.
  1) age는 12보다 작거나 같다.
  2) age는 b보다 작고 c보다 크다.
  3) age는 b보다 작고 c보다 크다.
  4) age는 b와 같지 않거나 c와 같다.

``` 풀이 :
1) age는 12보다 작거나 같다.
  조건식: age <= 12

2) age는 b보다 작고 c보다 크다.
  조건식: age < b && age > c

3) age는 b와 같지 않고 c와 같다.
  조건식: age != b && age == c
4) age는 b와 같지 않거나 c와 같다.
  조건식: age != b || age == c
```

9. 다음 조건문을 조건 연산자를 이용하여 한 문장으로 작성하라.
``` if(sum>100) sum = 100;
    else sum = 0;
```

``` 풀이 :
sum = (sum > 100) ? 100 : 0;
```

10. 다음 조건문을 조건 연산자를 이용하여 한 문장으로 작성하라.
``` if(n>5) System.out.println(n);
    else System.out.println(5);
```

``` 풀이 :
System.out.println((n > 5) ? n : 5);
```

11. System.out.print(text); 로 출력할 때 다음과 같이 출력되는 문자열 text는 무엇인가?
``` 를 출력하려면 \ 다음에 "를 붙여 \" 과 같이 하면 된다.
```

``` 풀이 :
문자열 내에서 큰따옴표를 출력하려면 \"로 이스케이핑하면 된다.
```

12. 다음 출력문에 의해 출력되는 텍스트는 무엇인가.
``` System.out.print("나는 \"Java를 " + 100 + "%\"" + "사랑해");
```

``` 풀이 :
나는 "Java를 100%"사랑해
````



