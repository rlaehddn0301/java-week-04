java 2주차 레포트
-------------

<pre>
<h2>1. 자바에서 클래스를 선언할 때 사용하는 자바의 키워드는?</h2>  
A : public class
<br>
<h2>2. 다음은 10과 20을 더해 합을 출력하려고 작성한 자바 프로그램이지만 오류가 있다.</h2>

      public class SampleProgram {
        int i;
        int j;
        i = 10;
        j = 20;
        System.out.println(i+j);
      }

  
  
       (1) 오류를 찾아내어 고쳐라.
  
         public class SampleProgram {
           public static void main(String[] args) {
           int i;
           int j;
           i = 10;
           j = 20;
           System.out.println(i+j);
           }  
         }
      
       (2) 이 자바 클래스를 저장하는 소스 파일 이름은 무엇인가?
  
        A : SampleProgram
  
       (3) 명령창에서 이 프로그램을 컴파일하는 명령은?
  
        A : javac SampleProgram.java
  
       (4) 명령창에서 이 프로그램을 실행하는 명령은?
  
        A : java SampleProgram.java
    
    <h2>3. 다음 중 식별자 사용이 잘못된 경우를 모두 골라라.</h2>
       int _i;
       int %j;
       char 안녕;
       double 1var;
       char student_ID;
       final int  abcdefghijklmnopqrstuvwxyz;
    
       A : int %j; // %기호는 자바 식별자에 사용 X
           double 1var; // 변수 이름은 숫자로 시작 X
    
    <h2>4. 다음 각 항목이 나타내는 변수를 선언하라.</h2>
       (1) int형 변수 height
  
        A : int height;
  
       (2) 0.25로 초기화된 double형 변수 size
  
        A : double size = 0.25;
  
       (3) height 변수의 값과 size 변수의 값을 더한 값으로 초기화된 double형 변수 total
  
        A : double total = height + size;
  
       (4) 문자 'a'로 초기화된 char형 변수 c
  
        A : char c = 'a';
  
       (5) 자신의 이름으로 초기화된 문자열 변수 name
  
        A : String name = "정진우";
    
    <h2>5. 다음 수식의 결과 값과 타입은?</h2>
       (1) 67 + 12.8
  
        A : 79.8 / double
  
       (2) 10/3
  
        A : 3 / int
  
       (3) 10.0/3
  
        A : 3.3333333333333335 / double
  
       (4) 10==9
  
        A : false / boolean
</pre>
