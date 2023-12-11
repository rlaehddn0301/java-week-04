java 10주차 레포트
=============


1. Scanner 클래스로 -1이 입력될 때까지 양의 정수를 입력받아 벡터에 저장하고 벡터를 검색하여 가장 큰 수를 출력하는 프로그램을 작성하라.

<pre>
  정수(-1이 입력될 때까지)>> 10 6 22 6 88 77 -1
  가장 큰 수는 88
</pre>

<pre>
  package Vector;

import java.util.Scanner;
import java.util.Vector;

public class MaxNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();

        System.out.print("정수(-1이 입력될 때까지)>> ");

        while (true) {
            int num = scanner.nextInt();

            if (num == -1) {
                break;
            }

            numbers.add(num);
        }

        if (numbers.isEmpty()) {
            System.out.println("입력된 정수가 없습니다.");
        } else {
            int maxNumber = findMaxNumber(numbers);
            System.out.println("가장 큰 수는 " + maxNumber);
        }

        scanner.close();
    }

    private static int findMaxNumber(Vector<Integer> numbers) {
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }

        return max;
    }
}
</pre>

2. Scanner 클래스를 사용하여 6개 학점('A', 'B', 'C', 'D', 'F')을 문자로 입력받아 ArrayList에 저장하고, ArrayList를 검색하여 학점을 점수 (A=4.0, B=3.0, C=2.0, D=1, F=0)로 변환하여 평균을 출력하는 프로그램을 작성하라.
<pre>
  6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>A C A B F D
  2.3333333333333333333333335
</pre>

<pre>
  import java.util.ArrayList;
import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> grades = new ArrayList<>();

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>> ");

        for (int i = 0; i < 6; i++) {
            char grade = scanner.next().charAt(0);
            grades.add(grade);
        }

        double average = calculateAverage(grades);
        System.out.println(average);

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Character> grades) {
        int totalScore = 0;
        int numberOfGrades = grades.size();

        for (char grade : grades) {
            totalScore += convertToScore(grade);
        }

        return (double) totalScore / numberOfGrades;
    }

    private static int convertToScore(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                throw new IllegalArgumentException("잘못된 학점이 입력되었습니다: " + grade);
        }
    }
}
</pre>

3. "그만"이 입력될 때까지 나라 이름과 인구를 입력받아 저장하고, 다시 나라 이름을 입력받아 인구를 출력하는 프로그램을 작성하라.

<pre>
  import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> populationMap = new HashMap<>();

        while (true) {
            System.out.print("나라 이름과 인구를 입력하세요 (그만 입력시 종료): ");
            String country = scanner.next();

            if (country.equals("그만")) {
                break;
            }

            int population = scanner.nextInt();
            populationMap.put(country, population);
        }

        System.out.print("조회할 나라 이름을 입력하세요: ");
        String lookupCountry = scanner.next();

        if (populationMap.containsKey(lookupCountry)) {
            System.out.println(lookupCountry + "의 인구는 " + populationMap.get(lookupCountry) + "명 입니다.");
        } else {
            System.out.println(lookupCountry + "에 대한 정보가 없습니다.");
        }

        scanner.close();
    }
}
</pre>

4. Vector 컬렉션을 이용하여 강수량의 평균을 유지 관리하는 프로그램을 작성하라. 강수량을 입력하면 벡터에 추가하고 현재 입력된 모든 강수량과 평균을 출력한다.

<pre>
  import java.util.Scanner;
import java.util.Vector;

public class RainfallTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Double> rainfallVector = new Vector<>();

        while (true) {
            System.out.print("강수량을 입력하세요 (음수 입력 시 종료): ");
            double rainfall = scanner.nextDouble();

            if (rainfall < 0) {
                break;
            }

            rainfallVector.add(rainfall);
            printRainfallInfo(rainfallVector);
        }

        scanner.close();
    }

    private static void printRainfallInfo(Vector<Double> rainfallVector) {
        System.out.print("현재 입력된 강수량: ");
        for (double rainfall : rainfallVector) {
            System.out.print(rainfall + " ");
        }

        System.out.println();
        System.out.println("평균 강수량: " + calculateAverage(rainfallVector));
    }

    private static double calculateAverage(Vector<Double> rainfallVector) {
        if (rainfallVector.isEmpty()) {
            return 0.0;
        }

        double totalRainfall = 0.0;

        for (double rainfall : rainfallVector) {
            totalRainfall += rainfall;
        }

        return totalRainfall / rainfallVector.size();
    }
}
</pre>

5. 하나의 학생 정보를 나타내는 Student 클래스에는 이름, 학과, 학번, 학점 평균을 저장하는 필드가 있다.
  (1) 학생마다 Student 객체를 생성하고 4명의 학생 정보를 ArrayList<Student> 컬렉션에 저장한 후에, ArrayList<Student>의 모든 학생 (4명) 정보를 출력하고 학생 이름을 입력받아 해당 학생의 학점 평균을 출력하는 프로그램을 작성하라.

<pre>
  import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String department;
    private String studentID;
    private double averageGrade;

    public Student(String name, String department, String studentID, double averageGrade) {
        this.name = name;
        this.department = department;
        this.studentID = studentID;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 학과: " + department + ", 학번: " + studentID + ", 평균 학점: " + averageGrade;
    }
}

public class StudentInfoProgram {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        // 4명의 학생 정보 생성 및 ArrayList에 추가
        studentList.add(new Student("홍길동", "컴퓨터공학", "2021001", 3.5));
        studentList.add(new Student("김철수", "전자공학", "2021002", 4.0));
        studentList.add(new Student("이영희", "경영학", "2021003", 3.8));
        studentList.add(new Student("박민지", "영문학", "2021004", 3.0));

        // 모든 학생 정보 출력
        System.out.println("모든 학생 정보:");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // 학생 이름 입력받아 해당 학생의 학점 평균 출력
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 이름을 입력하세요: ");
        String inputName = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getName().equals(inputName)) {
                System.out.println(student.getName() + "의 학점 평균: " + student.getAverageGrade());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("입력한 이름의 학생이 존재하지 않습니다.");
        }

        scanner.close();
    }
}
</pre>

6. 도시 이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고, 도시 이름을 '키'로 하는 HashMap<String, Location> 컬렉션을 만들고, 사용자로부터 입력 받아 4개의 도시를 저장하라. 그리고 도시이름으로 검색하는 프로그램을 작성하라.

<pre>
  import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Location {
    private String cityName;
    private double latitude;
    private double longitude;

    public Location(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "도시: " + cityName + ", 위도: " + latitude + ", 경도: " + longitude;
    }
}

public class CityLocationProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Location> cityMap = new HashMap<>();

        // 4개의 도시 정보 입력 및 Map에 추가
        for (int i = 0; i < 4; i++) {
            System.out.print("도시 이름을 입력하세요: ");
            String cityName = scanner.next();

            System.out.print("위도를 입력하세요: ");
            double latitude = scanner.nextDouble();

            System.out.print("경도를 입력하세요: ");
            double longitude = scanner.nextDouble();

            Location location = new Location(cityName, latitude, longitude);
            cityMap.put(cityName, location);
        }

        // 모든 도시 정보 출력
        System.out.println("모든 도시 정보:");
        for (Location location : cityMap.values()) {
            System.out.println(location);
        }

        // 도시 이름으로 검색
        System.out.print("검색할 도시 이름을 입력하세요: ");
        String searchCityName = scanner.next();

        Location foundLocation = cityMap.get(searchCityName);
        if (foundLocation != null) {
            System.out.println("검색한 도시 정보: " + foundLocation);
        } else {
            System.out.println("입력한 도시 이름의 정보가 존재하지 않습니다.");
        }

        scanner.close();
    }
}
</pre>

7. 이름과 학점(4.5만점)을 5개 입력 받아 해시맵에 저장하고, 장학생 선발 기준을 입력받아 장학생 명단을 출력하라.

<pre>
  import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScholarshipProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> studentMap = new HashMap<>();

        // 이름과 학점(4.5 만점)을 입력받아 해시맵에 저장
        for (int i = 0; i < 5; i++) {
            System.out.print("학생 이름을 입력하세요: ");
            String name = scanner.next();

            System.out.print("학점을 입력하세요 (4.5 만점): ");
            double grade = scanner.nextDouble();

            studentMap.put(name, grade);
        }

        // 장학생 선발 기준 입력
        System.out.print("장학생 선발 기준 학점을 입력하세요 (4.5 만점): ");
        double scholarshipCriteria = scanner.nextDouble();

        // 장학생 명단 출력
        System.out.println("장학생 명단:");
        for (Map.Entry<String, Double> entry : studentMap.entrySet()) {
            if (entry.getValue() >= scholarshipCriteria) {
                System.out.println("이름: " + entry.getKey() + ", 학점: " + entry.getValue());
            }
        }
</pre>

8. 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성하라. 프로그램은 고객의 이름과 포인트를 함께 저장 관리하는데, 포인트는 추가될 때마다 누적하여 저장된다.

<pre>
  import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerPointsProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> customerPointsMap = new HashMap<>();

        while (true) {
            // 고객 이름 입력
            System.out.print("고객 이름을 입력하세요 (종료하려면 '그만' 입력): ");
            String customerName = scanner.nextLine();

            if (customerName.equals("그만")) {
                break;
            }

            // 포인트 입력
            System.out.print("포인트를 입력하세요: ");
            int points = scanner.nextInt();

            // 기존 고객이면 포인트를 누적하여 업데이트, 없으면 새로 추가
            if (customerPointsMap.containsKey(customerName)) {
                int currentPoints = customerPointsMap.get(customerName);
                customerPointsMap.put(customerName, currentPoints + points);
            } else {
                customerPointsMap.put(customerName, points);
            }

            // 개행 문자 처리
            scanner.nextLine();
        }

        // 모든 고객의 포인트 출력
        System.out.println("고객별 포인트:");
        for (Map.Entry<String, Integer> entry : customerPointsMap.entrySet()) {
            System.out.println("고객: " + entry.getKey() + ", 포인트: " + entry.getValue());
        }

        scanner.close();
    }
}
</pre>

9. 다음 IStack 인터페이스가 있다.
<pre>
  interface IStack<T> {
	T pop();
	boolean push(T ob);
}
</pre>

IStackeT> 인터페이스를 구현(implements)하는 Mystack<T> 클래스를 작성하라.
스택의 원소는 Vector<E>를 이용하여 저장하라. 다음은 Mystack<Integer>로 구체 화한 정수 스택을 생성하고 활용하는 코드와 실행 결과이다.

<pre>
  import java.util.Vector;

interface IStack<T> {
    T pop();
    boolean push(T ob);
}

class Mystack<T> implements IStack<T> {
    private Vector<T> stack;

    public Mystack() {
        stack = new Vector<>();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean push(T ob) {
        return stack.add(ob);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class StackExample {
    public static void main(String[] args) {
        Mystack<Integer> intStack = new Mystack<>();

        // 스택에 값 추가
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        // 스택에서 값 꺼내기
        System.out.println(intStack.pop()); // 3
        System.out.println(intStack.pop()); // 2

        // 스택이 비어있는지 확인
        System.out.println("스택이 비어있는지 확인: " + intStack.isEmpty()); // false

        // 스택 모두 비우기
        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        // 스택이 비어있는지 확인
        System.out.println("스택이 비어있는지 확인: " + intStack.isEmpty()); // true
    }
}
</pre>

10. 10. vector<Shape>의 벡터를 이용하여 그래픽 편집기를 만들어보자. 본문 5.6절과 5.7 절에서 사례로 든 주상 클래스 Shape과 Line, Rect, Circle 클래스 코드를 잘 완성 하고 이를 활용하여 " 삽입". "삭제" " 모두 보기" "종료"의 4가지 그래픽 편집 기능 을 프로그램을 작성하라. 6장 실습문제 6번을 Vector<shape>을 이용하여 재작성하 는 연습이다. Vector를 이용하면 6장 실습문제 6번보다 훨씬 간단히 작성됨을 경험할 수 있다.

    <pre>
      import java.util.Scanner;
import java.util.Vector;

abstract class Shape {
    abstract void draw();
}

class Line extends Shape {
    @Override
    void draw() {
        System.out.println("Line을 그립니다.");
    }
}

class Rect extends Shape {
    @Override
    void draw() {
        System.out.println("Rect를 그립니다.");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle을 그립니다.");
    }
}

public class GraphicEditor {
    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 삽입  2. 삭제  3. 모두 보기  4. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertShape(shapes);
                    break;
                case 2:
                    deleteShape(shapes);
                    break;
                case 3:
                    viewAllShapes(shapes);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 선택하세요.");
            }
        }
    }

    private static void insertShape(Vector<Shape> shapes) {
        System.out.println("1. Line  2. Rect  3. Circle");
        System.out.print("도형을 선택하세요: ");
        Scanner scanner = new Scanner(System.in);
        int shapeType = scanner.nextInt();

        switch (shapeType) {
            case 1:
                shapes.add(new Line());
                break;
            case 2:
                shapes.add(new Rect());
                break;
            case 3:
                shapes.add(new Circle());
                break;
            default:
                System.out.println("유효하지 않은 도형입니다.");
        }
    }

    private static void deleteShape(Vector<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("삭제할 도형이 없습니다.");
            return;
        }

        System.out.println("삭제할 도형을 선택하세요:");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).getClass().getSimpleName());
        }

        Scanner scanner = new Scanner(System.in);
        int indexToDelete = scanner.nextInt() - 1;

        if (indexToDelete >= 0 && indexToDelete < shapes.size()) {
            shapes.remove(indexToDelete);
            System.out.println("선택한 도형을 삭제했습니다.");
        } else {
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    private static void viewAllShapes(Vector<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("등록된 도형이 없습니다.");
            return;
        }

        System.out.println("등록된 도형 목록:");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
    </pre>

11. 나라와 수도 맞추기 게임의 실행 예시는 다음과 같다.
  (1) 나라 이름(country)과 수도(capital)로 구성된 Nation 클래스를 작성하고 Vector<Nation> 컬렉션을 이용하여 프로그램을 작성하라.
  (2) 이 프로그램을 HashMap<String, String>을 이용하여 작성하라. '키' 는 나라 이름이고 '값' 은 수도이다.

<pre>
  (1) 나라 이름(country)과 수도(capital)로 구성된 Nation 클래스를 작성하고 Vector<Nation> 컬렉션을 이용하여 프로그램을 작성하라.
    import java.util.Scanner;
import java.util.Vector;

class Nation {
    private String country;
    private String capital;

    public Nation(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }
}

public class GuessCapitalGameWithVector {
    public static void main(String[] args) {
        Vector<Nation> nations = new Vector<>();
        nations.add(new Nation("한국", "서울"));
        nations.add(new Nation("미국", "워싱턴 D.C."));
        nations.add(new Nation("일본", "도쿄"));
        nations.add(new Nation("중국", "베이징"));
        nations.add(new Nation("영국", "런던"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("나라와 수도 맞추기 게임을 시작합니다.");
        System.out.println("나라의 수도를 맞춰보세요. (게임을 종료하려면 '그만' 입력)");

        while (true) {
            Nation randomNation = nations.get((int) (Math.random() * nations.size()));
            System.out.print(randomNation.getCountry() + "의 수도는? ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals("그만")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (userAnswer.equalsIgnoreCase(randomNation.getCapital())) {
                System.out.println("정답입니다!");
            } else {
                System.out.println("틀렸습니다. 정답은 " + randomNation.getCapital() + "입니다.");
            }
        }

        scanner.close();
    }
}
</pre>

<pre>
  (2) 이 프로그램을 HashMap<String, String>을 이용하여 작성하라. '키' 는 나라 이름이고 '값' 은 수도이다.
    import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessCapitalGameWithHashMap {
    public static void main(String[] args) {
        Map<String, String> nations = new HashMap<>();
        nations.put("한국", "서울");
        nations.put("미국", "워싱턴 D.C.");
        nations.put("일본", "도쿄");
        nations.put("중국", "베이징");
        nations.put("영국", "런던");

        Scanner scanner = new Scanner(System.in);

        System.out.println("나라와 수도 맞추기 게임을 시작합니다.");
        System.out.println("나라의 수도를 맞춰보세요. (게임을 종료하려면 '그만' 입력)");

        while (true) {
            String randomCountry = getRandomKey(nations);
            String randomCapital = nations.get(randomCountry);

            System.out.print(randomCountry + "의 수도는? ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals("그만")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (userAnswer.equalsIgnoreCase(randomCapital)) {
                System.out.println("정답입니다!");
            } else {
                System.out.println("틀렸습니다. 정답은 " + randomCapital + "입니다.");
            }
        }

        scanner.close();
    }

    private static String getRandomKey(Map<String, String> map) {
        int randomIndex = (int) (Math.random() * map.size());
        int currentIndex = 0;

        for (String key : map.keySet()) {
            if (currentIndex == randomIndex) {
                return key;
            }
            currentIndex++;
        }

        return null; // Should not reach here
    }
}
</pre>

12. Open Challenge를 수정하여 사용자가 단어를 삽입할 수 있도록 기능을 추가하라.

<pre>
  import java.util.ArrayList;
import java.util.Scanner;

public class OpenChallengeWithWordInsertion {
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("현재 단어 목록: " + wordList);
            System.out.println("1. 단어 추가  2. 단어 삭제  3. 모두 보기  4. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    insertWord(wordList, scanner);
                    break;
                case 2:
                    deleteWord(wordList, scanner);
                    break;
                case 3:
                    viewAllWords(wordList);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 선택하세요.");
            }
        }
    }

    private static void insertWord(ArrayList<String> wordList, Scanner scanner) {
        System.out.print("추가할 단어를 입력하세요 (종료하려면 '그만' 입력): ");
        String newWord = scanner.nextLine();

        if (newWord.equalsIgnoreCase("그만")) {
            System.out.println("단어 추가를 종료합니다.");
        } else {
            wordList.add(newWord);
            System.out.println("'" + newWord + "' 단어가 추가되었습니다.");
        }
    }

    private static void deleteWord(ArrayList<String> wordList, Scanner scanner) {
        System.out.print("삭제할 단어를 입력하세요: ");
        String wordToDelete = scanner.nextLine();

        if (wordList.remove(wordToDelete)) {
            System.out.println("'" + wordToDelete + "' 단어가 삭제되었습니다.");
        } else {
            System.out.println("해당 단어가 목록에 없습니다.");
        }
    }

    private static void viewAllWords(ArrayList<String> wordList) {
        if (wordList.isEmpty()) {
            System.out.println("단어 목록이 비어있습니다.");
        } else {
            System.out.println("현재 단어 목록: " + wordList);
        }
    }
}
</pre>

13. BRa 명령을 실행하는 소프트웨어를 작성하라. 명령은 다음과 같이 mov. 20d.
sub, jne, prt로 구성되며 mov sum e는 Sum 변수에 8을 삽입하고, add sum 1는 sum 변수에 1 값을 더하며, sub n 1은 n 변수의 값을 1 감소시키고, jne n 3은 변수 n의 값이 0이 아니면 3 번째 명령(실제 4번째 줄)으로 돌아가도록 처리하고, prt sum e은 sum 변수의 값을 출력하고 프로그램을 종료한다. prt에서 마지막 8은 특별한 의미가 없다. 80는 지금까지 입력한 프로그램을 처음부터 실행하도록 하는 지시어이다.
참고로, 실행 예시에서 첫 번째 프로그램은 5에서 15까지 더하는 프로그램이다.

<pre>
  import java.util.HashMap;
import java.util.Scanner;

class BRAInterpreter {
    private HashMap<String, Integer> variables;

    public BRAInterpreter() {
        this.variables = new HashMap<>();
    }

    public void executeProgram(String program) {
        String[] lines = program.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            String[] parts = line.split("\\s+");

            if (parts.length < 2) {
                System.out.println("잘못된 명령입니다: " + line);
                continue;
            }

            String command = parts[0];
            String variable = parts[1];

            switch (command) {
                case "mov":
                    if (parts.length == 4 && parts[2].equals("e")) {
                        int value = Integer.parseInt(parts[3]);
                        variables.put(variable, value);
                    } else {
                        System.out.println("잘못된 mov 명령입니다: " + line);
                    }
                    break;
                case "add":
                    if (parts.length == 3) {
                        int value = Integer.parseInt(parts[2]);
                        variables.put(variable, variables.getOrDefault(variable, 0) + value);
                    } else {
                        System.out.println("잘못된 add 명령입니다: " + line);
                    }
                    break;
                case "sub":
                    if (parts.length == 3) {
                        int value = Integer.parseInt(parts[2]);
                        variables.put(variable, variables.getOrDefault(variable, 0) - value);
                    } else {
                        System.out.println("잘못된 sub 명령입니다: " + line);
                    }
                    break;
                case "jne":
                    if (parts.length == 3) {
                        int jumpToLine = Integer.parseInt(parts[2]) - 1; // 0-based index
                        int currentValue = variables.getOrDefault(variable, 0);
                        if (currentValue != 0) {
                            i = jumpToLine;
                        }
                    } else {
                        System.out.println("잘못된 jne 명령입니다: " + line);
                    }
                    break;
                case "prt":
                    if (parts.length == 2) {
                        System.out.println(variables.getOrDefault(variable, 0));
                    } else {
                        System.out.println("잘못된 prt 명령입니다: " + line);
                    }
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다: " + line);
            }
        }
    }
}

public class BRAInterpreterExample {
    public static void main(String[] args) {
        String program1 = "mov sum e\nadd sum 1\nsub n 1\njne n 3\nprt sum e\n";
        String program2 = "mov sum e\nadd sum 5\nadd sum 10\nprt sum e\n";

        BRAInterpreter interpreter = new BRAInterpreter();
        interpreter.executeProgram(program1);
        System.out.println("------");
        interpreter.executeProgram(program2);
    }
}
</pre>
