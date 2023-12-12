java 2주차 레포트
-------------

<pre>
<h2>6. 체온 값 36.5로 초기화된 상수 bodyTemp를 double형으로 선언하라.</h2>
A : final double bodyTemp = 36.5;
  
<h2>7. 다음 각 항목의 코드에서 컴파일 오류를 수정하라.</h2>
  
(1) while(1) {}
  
 A : while(true)
  
(2) int n = 3.5;
  
 A : double n = 3.5;  // 3.5는 실수이기 때문에 int에 저장 X
  
(3) int b = (3<5)?true:false;

 A : int b = (3<5)?1:0;
  
(4) int score = 85;  // 자바에서는 연속된 비교 연산자를 사용할 수 없다. 조건을 분리해서 사용은 가능하다.
       if(80 < score < 90) 
     System.out.print(score);
            
 A : int score = 85;
       if(80 < score && score 90)
     System.out.print(score);

               
<h2>8. 다음 문장을 조건식으로 나타내라.</h2>

 (1) age는 12보다 작거나 같다.
         
  A : age <= 12
         
 (2) age는 b보다 작고 c보다 크다.

  A : age < b && age > c
    
 (3) age 빼기 5는 10과 같다.

  A : age - 5 == 10
    
 (4) age는 b와 같지 않거나 c와 같다.

  A : age != b || age == c

    
<h2>9. 다음 조건문을 조건 연산자를 이용하여 한 문장으로 작성하라.</h2>

  if(sum>100) sum = 100;
  else sum = 0;

  A : sum = (sum>100)? 100:0;

    
<h2>10. 다음 조건문을 조건 연산자를 이용하여 한 문장으로 작성하라.</h2>

  if(n>5) System.out.println(n);
  else System.out.println(5);

  A : System.out.println((n>5)? n:5);  

    
<h2>11. System.out.print(text);로 출력할 때 다음과 같이 출력되는 문자열 text는 무엇인가?</h2>

  "를 출력하려면 \ 다음에 "를 붙여 \"과 같이 하면 됩니다.
    
  A : "를 출력하려면 \ 다음에 "

    
<h2>12. 다음 출력문에 의해 출력되는 텍스트는 무엇인가.</h2>

  System.out.print("나는 \"Java를 " + 100 + "%\"" + "사랑해");

  A : 나는 "Java를 100%" 사랑해

    
</pre>
