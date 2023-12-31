java 7주차 레포트
=============

1. 자바 클래스를 작성하는 연습을 해보자. 다음  main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.
<pre>
public static void main(String [] args) {
  TV myTV = new TV("LG", 2017, 32); // LG에서 만든 2017년 32인치
  myTV.show();
}
</pre>

<pre>
  class TV {
    private String brand;
    private int year;
    private int inch;

    public TV(String brand, int year, int inch) {
        this.brand = brand;
        this.year = year;
        this.inch = inch;
    }

    public void show() {
        System.out.println(brand + "에서 만든 " + year + "년 " + inch + "인치");
    }
}

public class Main {
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 32); // LG에서 만든 2017년 32인치
        myTV.show();
    }
}
</pre>

2. Grade 클래스를 작성해보자. 3 과목의 점수를 입력받아 Grade 객체를 생성하고 성적 평균을 출력하는 main()과 실행 예시는 다음과 같다.
<pre>
import java.util.Scanner;

class Grade {
    private int math;
    private int science;
    private int english;

    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }

    public double average() {
        return (math + science + english) / 3.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
        int math = scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();

        Grade grade = new Grade(math, science, english);
        System.out.println("평균은 " + grade.average());
        scanner.close();
    }
}
</pre>

3. 노래 한 곡을 나타내는 Song 클래스를 작성하라. Song은 다음 필드로 구성된다.
    - 노래의 제목을 나타내는 title
    - 가수를 나타내는 artist
    - 노래가 발표된 연도를 나타내는 year
    - 국적을 나타내는 country

   또한 Song 클래스에 다음 생성자와 메소드를 작성하라.
     - 생성자 2개 : 기본 생성자와 매개변수로 모든 필드를 초기화하는 생성자
     - 노래 정보를 출력하는 show() 메소드
     - main() 메소드에서 197 8년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을 Song 객체로 생성하고 show()를 이용하여 노래의 정보를 다음과 같이 출력하라.
       <pre>
         1978년 스웨덴국적의 ABBA가 부른 Dancing Queen
       </pre>

<pre>
  public class Song {
    private String title;
    private String artist;
    private int year;
    private String country;


    // 생성자
    public Song(String title, String artist, int year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    // 제목 설정 메서드
    public void setTitle(String title) {
        this.title = title;
    }

    // 제목 얻기 메서드
    public String getTitle() {
        return title;
    }

    // 가수 설정 메서드
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // 가수 얻기 메서드
    public String getArtist() {
        return artist;
    }

    // 발표 연도 설정 메서드
    public void setYear(int year) {
        this.year = year;
    }

    // 발표 연도 얻기 메서드
    public int getYear() {
        return year;
    }

    // 국적 설정 메서드
    public void setCountry(String country) {
        this.country = country;
    }

    // 국적 얻기 메서드
    public String getCountry() {
        return country;
    }

    public static void main(String[] args) {
        // 노래 객체 생성
        Song mySong = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");

        // 노래 정보 출력
        System.out.println("노래 정보 출력:");
        mySong.show();

        // 정보 변경
        mySong.setTitle("새로운 노래");
        mySong.setArtist("새로운 가수");
        mySong.setYear(2023);
        mySong.setCountry("미국");

        // 수정된 노래 정보 출력
        System.out.println("수정된 노래 정보 출력:");
        mySong.show();
    }
}
</pre>

4. 다음 멤버를 가지고 직사각형을 표현하는 Rectangl 클래스를 작성하라.
    - int 타입의 x, y, width, height 필드 : 사각형을 구성하는 점과 크기 정보
    - x, y, width, height 값을 매개변수로 받아 필드를 초기화하는 생성자
    - int square() : 사각형 넓이 리턴
    - void show() : 사각형의 좌표와 넓이를 화면에 출력
    - boolean contains(Rectangle r) : 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴
    - main() 메소드의 코드와 실행 결과는 다음과 같다.

<pre>
  package Report_5;

class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.println("사각형의 좌표: (" + x + ", " + y + "), 넓이: " + square());
    }

    public boolean contains(Rectangle r) {
        return x < r.x && y < r.y && x + width > r.x + r.width && y + height > r.y + r.height;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);
        
        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) System.out.println("t는 r을 포함합니다.");
        if (t.contains(s)) System.out.println("t는 s를 포함합니다.");
    }
}
</pre>

5. 다음 설명대로 Circle 클래스와 CircleManager 클래스를 완성하라.
<pre>
  import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius; // x, y, radius 초기화
    }

    public void show() {
        System.out.println("(" + x + ", " + y + ") " + radius);
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle c[] = new Circle[3]; // 3개의 Circle 배열 선언
        for (int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >>");
            double x = scanner.nextDouble(); // x 값이 읽기
            double y = scanner.nextDouble(); // y 값이 읽기
            int radius = scanner.nextInt(); // 반지름 읽기
            c[i] = new Circle(x, y, radius); // Circle 객체 생성
        }
        for (int i = 0; i < c.length; i++) // 모든 Circle 객체 출력
            c[i].show();
        scanner.close();
    }
}
</pre>
<pre> 정답 :
x, y, radius >>3.0 3.0 5
x, y, radius >>2.5 2.7 6
x, y, radius >>5.0 2.0 4
(3.0, 3.0) 5
(2.5, 2.7) 6
(5.0, 2.0) 4
</pre>

6. 앞의 5번 문제는 정답이 공개되어 있다. 이 정답을 참고하여 Circle 클래스와 CircleManager 클래스를 수정하여 다음 실행 결과처럼 되게 하라.
<pre>
x, y, radius >>3.0 3.0 5
x, y, radius >>2.5 2.7 6
x, y, radius >>5.0 2.0 4
가장 면적이 큰 원은 (2.5, 2.7)6
</pre>

<pre>
package Report_5;

import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.println("(" + x + ", " + y + ") " + radius);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle c[] = new Circle[3];
        for (int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >>");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int radius = scanner.nextInt();
            c[i] = new Circle(x, y, radius);
        }

        double maxArea = 0;
        int maxIndex = 0;
        for (int i = 0; i < c.length; i++) {
            if (maxArea < c[i].getArea()) {
                maxArea = c[i].getArea();
                maxIndex = i;
            }
        }

        for (int i = 0; i < c.length; i++)
            c[i].show();

        System.out.print("가장 면적이 큰 원은 ");
        c[maxIndex].show();
        scanner.close();
    }
}
</pre>

7. 하루의 할 일을 표현하는 클래스 Day는 다음과 같다. 한 달의 할 일을 표현하는 MonthSchedule 클래스를 작성하라.
   또한 MonthSchedule 클래스에는 Day 객체 배열과 적절한 필드, 메소드를 작성하고 실행 예시처럼 입력, 보기, 끝내기 등의 3개의 기능을 작성하라.
<pre>
  package Report_5;

import java.util.Scanner;

class Day {
    private String work;

    public void set(String work) {
        this.work = work;
    }

    public String get() {
        return work;
    }

    public void show() {
        if (work == null)
            System.out.println("없습니다.");
        else
            System.out.println(work + "입니다.");
    }
}

class MonthSchedule {
    private int day;
    private Day[] schedule;

    public MonthSchedule(int day) {
        this.day = day;
        schedule = new Day[day];
        for (int i = 0; i < day; i++)
            schedule[i] = new Day();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("날짜(1~" + day + ")? ");
        int index = scanner.nextInt();
        System.out.print("할일(빈칸없이 입력)? ");
        String work = scanner.next();
        schedule[index - 1].set(work);
    }

    public void view() {
        for (int i = 0; i < day; i++) {
            System.out.print((i + 1) + "일의 할 일은 ");
            schedule[i].show();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이번 달의 일수 입력: ");
        int day = scanner.nextInt();
        MonthSchedule monthSchedule = new MonthSchedule(day);
        for (int i = 0; i < day; i++)
            monthSchedule.input();
        monthSchedule.view();
        scanner.close();
    }
}
</pre>

8. 이름(name), 전화번호(tel) 필드와 생성자 등을 가진 Phone 클래스를 작성하고, 실행 예시와 가팅 작동하는 PhoneBook 클래스를 작성하라.
<pre>
  
</pre>

