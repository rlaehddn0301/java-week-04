java 9주차 레포트
=============

1. 다음 main()이 실행되면 아래 예시와 같이 출력되도록 MyPoint 클래스를 작성하라 
<pre>
  package six;

public class MyPoint1 {

	public static void main(String[] args) {
		MyPoint  p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);
		System.out.println(p);
		if(p.equals(q))
			System.out.println("같은 점");
		else
			System.out.println("다른 점");
	}

}
</pre>

<pre>
  package six;

public class MyPoint1 {

    public static class MyPoint {
        private int x;
        private int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyPoint myPoint = (MyPoint) obj;
            return x == myPoint.x && y == myPoint.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        MyPoint p = new MyPoint(3, 50);
        MyPoint q = new MyPoint(4, 50);
        System.out.println(p);
        if (p.equals(q))
            System.out.println("같은 점");
        else
            System.out.println("다른 점");
    }
}
</pre>

2. 중심을 나타내는 정수 x, y와 반지름 radius 필드를 가지는 Circle 클래스를 작성하고자 한다. 생성자는 3개의 인자(x, y, Circle)를 받아 해당 필드를 초기화하고,
   equals() 메소드는 두개의 Circle 객체의 중심이 같으면 같은것으로 판별하도록 한다.

<pre>
  package six;

public class Circle {

	public static void main(String[] args) {
		Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
		Circle ㅠ = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
		System.out.println("원 a : " + a);
		System.out.println("원 b : " + b);
		if(a.equals(b))
			System.out.println("같은 원");
		else
			System.out.println("서로 다른 원");
	}

}
</pre>

<pre>
  package six;

public class Circle {

    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Circle circle = (Circle) obj;
        return x == circle.x && y == circle.y;
    }

    @Override
    public String toString() {
        return "중심: (" + x + ", " + y + "), 반지름: " + radius;
    }

    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5); // 중심 (2, 3)에 반지름 5인 원
        Circle b = new Circle(2, 3, 30); // 중심 (2, 3)에 반지름 30인 원
        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        if (a.equals(b))
            System.out.println("같은 원");
        else
            System.out.println("서로 다른 원");
    }
}
</pre>

3. 다음 코드를 수정하여, Calc 클래스는 etc 패키지에. MainApp 클래스는 main 패키지로 분리 작성하라.
  <pre>
    package six;

class Calc {
	private int x, y;
	public Calc(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int sum() {
		return x+y;
	}
}

public class MainApp {

	public static void main(String[] args) {
		Calc c = new Calc(10, 20);
		System.out.println(c.sum());

	}

}
  </pre>

  <pre>
    // etc 패키지에 위치한 Calc 클래스
package etc;

public class Calc {
    private int x, y;

    public Calc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int sum() {
        return x + y;
    }
}
  </pre>

  <pre>
    // main 패키지에 위치한 MainApp 클래스
package main;

import etc.Calc;

public class MainApp {

    public static void main(String[] args) {
        Calc c = new Calc(10, 20);
        System.out.println(c.sum());
    }
}
  </pre>

4. 다음 코드를 수정하여 Shape 클래스는 base 패키지에, Circle 클래스는 derived 패키지에. GraphicEditor 클래스는 app 패키지에 분리 작성하라.

	<pre>
		// base 패키지에 위치한 Shape 클래스
package base;

public class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}
	</pre>

 <pre>
	 // derived 패키지에 위치한 Circle 클래스
package derived;

import base.Shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
 </pre>

 <pre>
	 // app 패키지에 위치한 GraphicEditor 클래스
package app;

import base.Shape;
import derived.Circle;

public class GraphicEditor {

    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}

 </pre>

 5. Calendar 객체를 생성하면 현재 시간을 알 수 있다. 프로그램을 실행한 현재 시간이 새벽 4시에서 낮 12시 이전이면 "Good Morning"을, 오후 6시 이전이면 "Good Afternoon"을, 밤 10시 이전이면 "Good Evening"을, 그 이후는 "Good Night"을 출력하는 프로그램을 작성하라.

    <pre>
	    현재 시간은 10시 22분입니다.
	    Good Morning
    </pre>

    <pre>
	    import java.util.Calendar;

public class GreetingProgram {

    public static void main(String[] args) {
        // Calendar 객체를 이용하여 현재 시간 정보 가져오기
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // 현재 시간 출력
        System.out.println("현재 시간은 " + hour + "시 " + minute + "분입니다.");

        // 현재 시간에 따라 다른 인사말 출력
        if (hour >= 4 && hour < 12) {
            System.out.println("Good Morning");
        } else if (hour < 18) {
            System.out.println("Good Afternoon");
        } else if (hour < 22) {
            System.out.println("Good Evening");
        } else {
            System.out.println("Good Night");
        }
    }
}
    </pre>

6. 경과시간을 맞추는 게임을 작성하라. 다음 예시를 참고하면, <Enter> 키를 입력하면 현재 초 시간을 보여주고 여기서 10초에 더 근접하도록 다음 <Enter> 키를 입력한 사람이 이기는 게임이다.

   <pre>
	   10초에 가까운 사람이 이기는 게임입니다.
	   황기태 시작 <Enter>키>>
		   현재 초 시간 = 42
	   10초 예상 후 <Enter>키>>
		   현재 초 시간 = 50
	   이재문 시작 <Enter>키>>
		   현재 초 시간 = 51
	   10초 예상 후 <Enter>키>>
		   현재 초 시간 = 4
	   황기태의 결과 8, 이재문의 결과 13, 승자는 황기태
   </pre>

   <pre>
	   import java.util.Scanner;

public class ElapsedTimeGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");

        // 황기태 정보 입력
        System.out.print("황기태 시작 <Enter>키>>");
        scanner.nextLine();
        int startTime1 = getCurrentSecond();
        System.out.println("현재 초 시간 = " + startTime1);

        // 이재문 정보 입력
        System.out.print("이재문 시작 <Enter>키>>");
        scanner.nextLine();
        int startTime2 = getCurrentSecond();
        System.out.println("현재 초 시간 = " + startTime2);

        // 황기태 예상 초 시간 입력
        System.out.print("10초 예상 후 <Enter>키>>");
        scanner.nextLine();
        int endTime1 = getCurrentSecond();
        System.out.println("현재 초 시간 = " + endTime1);

        // 이재문 예상 초 시간 입력
        System.out.print("10초 예상 후 <Enter>키>>");
        scanner.nextLine();
        int endTime2 = getCurrentSecond();
        System.out.println("현재 초 시간 = " + endTime2);

        // 결과 계산
        int result1 = Math.abs(endTime1 - startTime1);
        int result2 = Math.abs(endTime2 - startTime2);

        // 결과 출력 및 승자 결정
        System.out.println("황기태의 결과 " + result1 + ", 이재문의 결과 " + result2 + ", 승자는 " + (result1 < result2 ? "황기태" : "이재문"));

        scanner.close();
    }

    // 현재 초 시간을 반환하는 메서드
    private static int getCurrentSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
   </pre>

7. Scanner를 이용하여 한 라인을 읽고, 공백으로 분리된 어절이 몇 개 들어 있는지 "그만"을 입력할 때까지 반복하는 프로그램을 작성하라.

<pre>
	>> I love Java
	어절 개수는 3
	>>자바는 객체 지향 언어로서 매우 좋은 언어이다.
	어절 개수는 7
	>>그만
	종료합니다...

	1) StringTokenizer 클래스를 이용하여 작성하라.
	2) String 클래스의 split() 메소드를 이용하여 작성하라.
</pre>

<pre>
	1) StringTokenizer 클래스를 이용하여 작성하라.

	import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCountWithTokenizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }

            int wordCount = countWordsWithTokenizer(input);
            System.out.println("어절 개수는 " + wordCount);
        }

        scanner.close();
    }

    private static int countWordsWithTokenizer(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        return tokenizer.countTokens();
    }
}
</pre>

<pre>
	2) String 클래스의 split() 메소드를 이용하여 작성하라.

	import java.util.Scanner;

public class WordCountWithSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }

            int wordCount = countWordsWithSplit(input);
            System.out.println("어절 개수는 " + wordCount);
        }

        scanner.close();
    }

    private static int countWordsWithSplit(String input) {
        String[] words = input.split("\\s+");
        return words.length;
    }
}

</pre>

8. 문자열을 입력받아 한 글자씩 회전시켜 모드 출력하는 프로그램을 작성하라.

<pre>
	문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다.
	I love you
</pre>

<pre>
	import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈칸이나 있어도 되고 영어 한글 모두 됩니다.");
        String input = scanner.nextLine();

        rotateAndPrint(input);

        scanner.close();
    }

    private static void rotateAndPrint(String str) {
        for (int i = 0; i < str.length(); i++) {
            char rotatedChar = rotateChar(str.charAt(i));
            System.out.print(rotatedChar);
        }
    }

    private static char rotateChar(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) ('A' + (ch - 'A' + 1) % 26);
        } else if (Character.isLowerCase(ch)) {
            return (char) ('a' + (ch - 'a' + 1) % 26);
        } else {
            return ch;
        }
    }
}
</pre>

9. 철수와 컴퓨터의 가위바위보 게임을 만들어보자. 가위, 바위, 보는 각각 1, 2, 3 키이다. 철수가 키를 입력하면, 동시에 프로그램도 Math.Random()을 이용하여 1, 2, 3 중에 한 수를 발생시키고 이것을 컴퓨터가 낸 것으로 한다. 그런 다음 철수와 컴퓨터 중 누가 이겼는지 판별하여 승자를 출력하라.
<pre>
	철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>1
	철수(가위) : 컴퓨터(바위)
	컴퓨터가 이겼습니다.
	철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>3
	철수(보) : 컴퓨터(가위)
	철수가 이겼습니다.
	철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>4
</pre>

<pre>
	import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
            int userInput = scanner.nextInt();

            if (userInput == 4) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (userInput < 1 || userInput > 3) {
                System.out.println("1, 2, 3 중에서 선택해주세요.");
                continue;
            }

            int computerInput = generateComputerInput();
            printResult(userInput, computerInput);
        }

        scanner.close();
    }

    private static int generateComputerInput() {
        return (int) (Math.random() * 3) + 1;
    }

    private static void printResult(int user, int computer) {
        System.out.print("철수(" + convertToGesture(user) + ") : 컴퓨터(" + convertToGesture(computer) + ")\n");

        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == 1 && computer == 3) || (user == 2 && computer == 1) || (user == 3 && computer == 2)) {
            System.out.println("철수가 이겼습니다.");
        } else {
            System.out.println("컴퓨터가 이겼습니다.");
        }
    }

    private static String convertToGesture(int number) {
        switch (number) {
            case 1:
                return "가위";
            case 2:
                return "바위";
            case 3:
                return "보";
            default:
                return "잘못된 입력";
        }
    }
}
</pre>

10. 갬블링 게임을 만들어보자. 두 사람이 게임을 진행한다. 이들의 이름을 키보드로 입력 받으며 각 사람은 Person 클래스로 작성하라. 그러므로 프로그램에는 2개의 person 객체가 생성되어야 한다. 두 사람은 번갈아 가면서 게임을 진행하는데 각 사람이 자기 차례에서 <Enter> 키를 입력하면, 3개의 난수가 발생되고 이 숫자가 모두 같으면 승 자가 되고 게임이 끝난다. 난수의 범위를 너무 크게 잡으면 3개의 숫자가 일치하게 나 올 가능성이 적기 때문에 숫자의 범위는 1~3까지로 한다.

<pre>
	1번째 선수 이름>>수희
	2번째 선수 이름>>연수

	[수희]:<Enter>
		3	1	1 아쉽군요!
	[연수]:<Enter>
		3	1	3 아쉽군요!
	[수희]:<Enter>
		2	2	1 아쉽군요!
	[연수]:<Enter>
		1	1	2 아쉽군요!
	[수희]:<Enter>
		3	3	3 수희님이 이겼습니다!
</pre>

<pre>
	import java.util.Scanner;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1번째 선수 이름>>");
        Person player1 = new Person(scanner.nextLine());

        System.out.print("2번째 선수 이름>>");
        Person player2 = new Person(scanner.nextLine());

        playGame(scanner, player1, player2);

        scanner.close();
    }

    private static void playGame(Scanner scanner, Person player1, Person player2) {
        while (true) {
            System.out.print("[" + player1.getName() + "]:<Enter>");
            scanner.nextLine();
            int[] result1 = generateRandomNumbers();
            printResult(result1);

            System.out.print("[" + player2.getName() + "]:<Enter>");
            scanner.nextLine();
            int[] result2 = generateRandomNumbers();
            printResult(result2);

            if (isWinner(result1) || isWinner(result2)) {
                System.out.println(getWinner(player1, player2, result1, result2) + "님이 이겼습니다!");
                break;
            } else {
                System.out.println("아쉽군요!");
            }
        }
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (int) (Math.random() * 3) + 1;
        }
        return numbers;
    }

    private static void printResult(int[] result) {
        for (int number : result) {
            System.out.print("\t" + number);
        }
        System.out.println();
    }

    private static boolean isWinner(int[] result) {
        return result[0] == result[1] && result[1] == result[2];
    }

    private static String getWinner(Person player1, Person player2, int[] result1, int[] result2) {
        if (isWinner(result1)) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }
}
</pre>

11. StringBuffer 클래스를 활용하여 명령처럼 문자열을 수정하라. 아래 실행 예시에서 love!LOVE는 love를 찾아 LOVE로 수정하라는 명령이다. 첫 번째 만난 문자열만 수정한다.

<pre>
	>>우리는 love Java Programming.
	명령: 우리는!We
	We love Java Programming.
	명령: LOV!사랑
	찾을 수 없습니다!
	명령: !Java
	잘못된 명령입니다!
	명령: love!LOVE
	We love Java Programming.
	명령: 그만
	종료합니다
</pre>

<pre>
	import java.util.Scanner;

public class CommandEditing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer("우리는 love Java Programming.");

        while (true) {
            System.out.println(">>" + buffer.toString());
            System.out.print("명령: ");
            String command = scanner.nextLine();

            if (command.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }

            if (command.contains("!")) {
                int index = buffer.indexOf("love");
                if (index != -1) {
                    buffer.replace(index, index + "love".length(), "LOVE");
                    System.out.println(buffer.toString());
                } else {
                    System.out.println("찾을 수 없습니다!");
                }
            } else {
                System.out.println("잘못된 명령입니다!");
            }
        }

        scanner.close();
    }
}
</pre>

12. 문제 10의 갬블링 게임을 n명이 하도록 수정하라. 실행 예시와 같이 게임에 참여하는 선수를 입력 받고 각 선수의 이름을 입력받도록 수정하라.
<pre>
	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class MultiPlayerGamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임에 참여하는 선수의 수를 입력하세요: ");
        int numOfPlayers = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        List<Person> players = new ArrayList<>();

        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.print(i + "번째 선수 이름>> ");
            String playerName = scanner.nextLine();
            players.add(new Person(playerName));
        }

        playGame(scanner, players);

        scanner.close();
    }

    private static void playGame(Scanner scanner, List<Person> players) {
        while (true) {
            for (Person player : players) {
                System.out.print("[" + player.getName() + "]:<Enter>");
                scanner.nextLine();
                int[] result = generateRandomNumbers();
                printResult(result);

                if (isWinner(result)) {
                    System.out.println(player.getName() + "님이 이겼습니다!");
                    return;
                } else {
                    System.out.println("아쉽군요!");
                }
            }
        }
    }

    private static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (int) (Math.random() * 3) + 1;
        }
        return numbers;
    }

    private static void printResult(int[] result) {
        for (int number : result) {
            System.out.print("\t" + number);
        }
        System.out.println();
    }

    private static boolean isWinner(int[] result) {
        return result[0] == result[1] && result[1] == result[2];
    }
}
</pre>
