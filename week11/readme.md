java 11주차 레포트
=============

1. Scanner로 입력받은 이름과 전화번호를 한 줄에 한 사람씩 c:\temp\phone.txt 파일에 저장하라 "그만"을 입력하면 프로그램을 종료한다.

<pre>
  import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBookWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(new FileWriter("c:\\temp\\phone.txt"))) {
            System.out.println("이름과 전화번호를 입력하세요. (종료하려면 '그만' 입력)");

            while (true) {
                System.out.print("이름: ");
                String name = scanner.nextLine();

                if (name.equals("그만")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                System.out.print("전화번호: ");
                String phoneNumber = scanner.nextLine();

                // 입력받은 이름과 전화번호를 파일에 저장
                writer.println(name + ": " + phoneNumber);
            }
        } catch (IOException e) {
            System.err.println("파일에 쓰기 오류: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
</pre>

2. 앞서 저장한 c:\temp\phone.txt 파일을 읽어 화면에 출력하라.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneBookReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("c:\\temp\\phone.txt"))) {
            System.out.println("=== 전화번호부 내용 ===");
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
</pre>

3. c:\window\system.ini 파일을 읽어 소문자를 모두 대문자로 바꾸어 출력하라.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConvertToUpper {
    public static void main(String[] args) {
        String filePath = "c:\\windows\\system.ini";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String upperCaseLine = line.toUpperCase();
                System.out.println(upperCaseLine);
            }

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
</pre>

4. c:\window\system.ini 파일에 라인 번호를 붙여 출력하라.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineNumbering {
    public static void main(String[] args) {
        String filePath = "c:\\windows\\system.ini";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
</pre>

5. 2개의 파일을 입력받고 비교하여 같으면 "파일이 같습니다.", 틀리면 "파일이 서로 다릅니다."를 출력하는 프로그램을 작성하라. 텍스트 및 바이너리 파일 모두를 포함한다. 아래 실횅 예시에서는 프로젝트 폴더에 elvis1.txt와 복사본 elvis1-복사본.txt를 미리 준비해 두었다.

<pre>
  import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileComparator {
    public static void main(String[] args) {
        String filePath1 = "elvis1.txt";
        String filePath2 = "elvis1-복사본.txt";

        if (compareFiles(filePath1, filePath2)) {
            System.out.println("파일이 같습니다.");
        } else {
            System.out.println("파일이 서로 다릅니다.");
        }
    }

    private static boolean compareFiles(String filePath1, String filePath2) {
        try (FileInputStream fileInputStream1 = new FileInputStream(filePath1);
             FileInputStream fileInputStream2 = new FileInputStream(filePath2)) {

            int byte1, byte2;

            while ((byte1 = fileInputStream1.read()) != -1 && (byte2 = fileInputStream2.read()) != -1) {
                if (byte1 != byte2) {
                    return false; // 바이너리 파일이 서로 다름
                }
            }

            // 파일의 끝에 도달했을 때
            return true;

        } catch (IOException e) {
            System.err.println("파일 비교 중 오류: " + e.getMessage());
            return false;
        }
    }

    private static boolean compareTextFiles(String filePath1, String filePath2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1, line2;

            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    return false; // 텍스트 파일이 서로 다름
                }
            }

            // 파일의 끝에 도달했을 때
            return true;

        } catch (IOException e) {
            System.err.println("파일 비교 중 오류: " + e.getMessage());
            return false;
        }
    }
}
</pre>

6. 사용자로부터 두 개의 텍스트 파일 이름을 입력받고 첫 번째 파일 뒤에 두 번째 파일을 덧붙인 새로운 파일을 생성하는 프로그램을 작성하라. 아래 실행 예시에서는 프로젝트 폴더에 elvis1.txt와 elveis2.txt를 미리 준비해 두었다.

<pre>
  import java.io.*;

public class MergeTextFiles {
    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("첫 번째 파일 이름을 입력하세요: ");
            String filePath1 = reader1.readLine();

            System.out.print("두 번째 파일 이름을 입력하세요: ");
            String filePath2 = reader1.readLine();

            mergeFiles(filePath1, filePath2);

            System.out.println("파일 덧붙이기가 완료되었습니다.");

        } catch (IOException e) {
            System.err.println("입출력 오류: " + e.getMessage());
        }
    }

    private static void mergeFiles(String filePath1, String filePath2) {
        try (BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
             BufferedWriter writer = new BufferedWriter(new FileWriter("merged_file.txt", true))) {

            String line;

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("파일 덧붙이기 중 오류: " + e.getMessage());
        }
    }
}
</pre>

7. 파일 복사 연습을 해보자. 이미지 복사가 진행하는 동안 10% 진행할 때마다 '*' 하나씩 출력하도록 하라. 아래 실행 예시에서는 프로젝트 폴더 밑에 a.jpg을 미리 준비해두었다.

<pre>
  import java.io.*;

public class FileCopyWithProgress {
    public static void main(String[] args) {
        String sourceFilePath = "a.jpg";
        String destinationFilePath = "copied_image.jpg";

        try (InputStream inputStream = new FileInputStream(sourceFilePath);
             OutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            long fileSize = new File(sourceFilePath).length();
            long bytesRead = 0;
            int bytesReadThisTime;
            byte[] buffer = new byte[1024];

            while ((bytesReadThisTime = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesReadThisTime);
                bytesRead += bytesReadThisTime;

                // 진행 상황 출력
                printProgress(bytesRead, fileSize);
            }

            System.out.println("\n파일 복사가 완료되었습니다.");

        } catch (IOException e) {
            System.err.println("파일 복사 중 오류: " + e.getMessage());
        }
    }

    private static void printProgress(long bytesRead, long fileSize) {
        int progressPercentage = (int) ((bytesRead * 100) / fileSize);

        if (progressPercentage % 10 == 0) {
            System.out.print("*");
        }
    }
}
</pre>

8. File 클래스를 이용하여 c:\에 있는 파일 중에서 제일 큰 파일의 이름과 크기를 출력하라.

<pre>
  import java.io.File;

public class LargestFileInDirectory {
    public static void main(String[] args) {
        String directoryPath = "c:\\";

        File directory = new File(directoryPath);
        File largestFile = findLargestFile(directory);

        if (largestFile != null) {
            System.out.println("제일 큰 파일 이름: " + largestFile.getName());
            System.out.println("크기: " + largestFile.length() + " bytes");
        } else {
            System.out.println("디렉토리에 파일이 없습니다.");
        }
    }

    private static File findLargestFile(File directory) {
        File[] files = directory.listFiles();
        File largestFile = null;
        long maxSize = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() > maxSize) {
                    maxSize = file.length();
                    largestFile = file;
                }
            }
        }

        return largestFile;
    }
}
</pre>

9. c:\temp에 있는 .txt 파일만 삭제하는 프로그램을 작성하라. c:\나 c:\windows 등의 디렉터리에 적용하면 중요한 파일이 삭제될 수 있으니 조심하라.

<pre>
  import java.io.File;

public class DeleteTxtFilesInTempDirectory {
    public static void main(String[] args) {
        String directoryPath = "c:\\temp";

        File directory = new File(directoryPath);
        deleteTxtFiles(directory);
    }

    private static void deleteTxtFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    if (file.delete()) {
                        System.out.println(file.getName() + " 파일이 삭제되었습니다.");
                    } else {
                        System.out.println("파일 삭제 실패: " + file.getName());
                    }
                }
            }
        }
    }
}
</pre>

10. 전화번호를 미리 c:\temp\phone.txt 파일에 여러 개 저장해둔다. 이 파일을 읽어 다음 실행 예시와 같은 작동하는 검색 프로그램을 작성하라.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneSearchProgram {
    public static void main(String[] args) {
        String filePath = "c:\\temp\\phone.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("전화번호 검색 프로그램");
            System.out.println("=======================");

            // 파일에서 전화번호 읽어오기
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phoneNumber = parts[1].trim();
                    System.out.println("이름: " + name + "\t전화번호: " + phoneNumber);
                }
            }

            // 검색 기능
            searchPhoneNumber(reader);

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
    }

    private static void searchPhoneNumber(BufferedReader reader) throws IOException {
        System.out.println("=======================");
        System.out.print("검색할 이름을 입력하세요 (종료: '그만'): ");

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            String searchName;
            while (!(searchName = inputReader.readLine()).equals("그만")) {
                boolean found = false;
                String line;
                reader.reset(); // BufferedReader를 처음으로 리셋

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        String phoneNumber = parts[1].trim();
                        if (name.equals(searchName)) {
                            System.out.println("전화번호: " + phoneNumber);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("해당하는 이름의 전화번호가 없습니다.");
                }

                System.out.print("검색할 이름을 입력하세요 (종료: '그만'): ");
            }
        }
    }
}
</pre>

11. word.txt 파일( 출판사 홈페이지에 자료로 제공. 현재 이 문제의 정답 프로젝트에도 있음 )에는 한 라인에 하나의 영어 단어가 들어 있다. 이 파일을 한 라인씩 읽어 Vector<String>에 라인별로 삽입하고 저장하고, 영어 단어를 입력받아 그 단어로 시작하는 모든 단어를 벡터에서 찾아 출력하는 프로그램을 작성하라.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class WordSearchProgram {
    public static void main(String[] args) {
        String filePath = "word.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Vector<String> wordsVector = new Vector<>();

            // 파일에서 영어 단어를 벡터에 저장
            String line;
            while ((line = reader.readLine()) != null) {
                wordsVector.add(line.trim());
            }

            // 사용자로부터 영어 단어 입력받고 시작하는 단어 찾기
            searchWords(wordsVector);

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
    }

    private static void searchWords(Vector<String> wordsVector) throws IOException {
        System.out.println("영어 단어 검색 프로그램");
        System.out.println("=======================");

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("검색할 영어 단어를 입력하세요 (종료: '그만'): ");
            String searchWord;

            while (!(searchWord = inputReader.readLine()).equals("그만")) {
                boolean found = false;

                for (String word : wordsVector) {
                    if (word.startsWith(searchWord)) {
                        System.out.println(word);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("해당하는 단어가 없습니다.");
                }

                System.out.print("검색할 영어 단어를 입력하세요 (종료: '그만'): ");
</pre>

12. 텍스트 파일에 있는 단어를 검색하는 프로그램을 작성해보자. 실행 예시는 프로젝트 폴더 밑에 자신이 작성한 자바 파일(예 : test.java)을 복사하여 두고 읽는 경우이다.

<pre>
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordSearchInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("검색할 단어를 입력하세요: ");
        String searchWord = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("test.java"))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.contains(searchWord)) {
                    System.out.println("라인 " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("입력한 단어를 포함하는 라인이 없습니다.");
            }

        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
</pre>

13. 간단한 파일 탐색기를 만들어보자. 처음 시작은 c:\에서부터 시작한다. 명령은 크게 2가지로ㅓ서 ".."를 입력하면 부모 디렉터리로 이동하고, "디렉터리명"을 입력하면 서브 디렉터리로 이동하여 파일리스트를 보여준다.

<pre>
  import java.io.File;
import java.util.Scanner;

public class SimpleFileExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File currentDirectory = new File("c:\\");

        while (true) {
            // 현재 디렉터리의 파일 리스트 출력
            listFilesInDirectory(currentDirectory);

            // 사용자로부터 명령 입력 받기
            System.out.print("명령을 입력하세요 ('..'으로 상위 디렉터리 이동, '디렉터리명'으로 하위 디렉터리 이동): ");
            String command = scanner.nextLine();

            if (command.equals("..")) {
                // 상위 디렉터리로 이동
                String parentPath = currentDirectory.getParent();
                if (parentPath != null) {
                    currentDirectory = new File(parentPath);
                } else {
                    System.out.println("더 이상 상위 디렉터리가 없습니다.");
                }
            } else {
                // 하위 디렉터리로 이동
                File newDirectory = new File(currentDirectory, command);
                if (newDirectory.isDirectory()) {
                    currentDirectory = newDirectory;
                } else {
                    System.out.println("유효하지 않은 디렉터리입니다.");
                }
            }
        }
    }

    private static void listFilesInDirectory(File directory) {
        System.out.println("현재 디렉터리: " + directory.getAbsolutePath());
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
</pre>

14. 문제 13을 확장하여 다음 명령을 추가하라.

<pre>
>>rename phone.txt p.txt // phone.txt를 p.txt로 변경. 파일과 디렉터리 이름 변경
>>mkdir XXX // 현재 디렉터리 밑에 XXX 디렉터리 생성
</pre>

<pre>
  import java.io.File;
import java.util.Scanner;

public class ExtendedFileExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File currentDirectory = new File("c:\\");

        while (true) {
            // 현재 디렉터리의 파일 리스트 출력
            listFilesInDirectory(currentDirectory);

            // 사용자로부터 명령 입력 받기
            System.out.print("명령을 입력하세요 ('..'으로 상위 디렉터리 이동, '디렉터리명'으로 하위 디렉터리 이동, " +
                    "'rename 파일명 새이름', 'mkdir 디렉터리명'): ");
            String command = scanner.nextLine();

            if (command.equals("..")) {
                // 상위 디렉터리로 이동
                String parentPath = currentDirectory.getParent();
                if (parentPath != null) {
                    currentDirectory = new File(parentPath);
                } else {
                    System.out.println("더 이상 상위 디렉터리가 없습니다.");
                }
            } else if (command.startsWith("rename ")) {
                // 파일 또는 디렉터리 이름 변경
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    renameFileOrDirectory(parts[1], parts[2]);
                } else {
                    System.out.println("올바른 rename 명령 형식이 아닙니다.");
                }
            } else if (command.startsWith("mkdir ")) {
                // 새로운 디렉터리 생성
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    createDirectory(parts[1]);
                } else {
                    System.out.println("올바른 mkdir 명령 형식이 아닙니다.");
                }
            } else {
                // 하위 디렉터리로 이동
                File newDirectory = new File(currentDirectory, command);
                if (newDirectory.isDirectory()) {
                    currentDirectory = newDirectory;
                } else {
                    System.out.println("유효하지 않은 디렉터리입니다.");
                }
            }
        }
    }

    private static void listFilesInDirectory(File directory) {
        System.out.println("현재 디렉터리: " + directory.getAbsolutePath());
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    private static void renameFileOrDirectory(String oldName, String newName) {
        File fileToRename = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);

        if (fileToRename.exists()) {
            if (fileToRename.renameTo(newFile)) {
                System.out.println("파일 또는 디렉터리 이름 변경 성공!");
            } else {
                System.out.println("파일 또는 디렉터리 이름 변경 실패.");
            }
        } else {
            System.out.println("존재하지 않는 파일 또는 디렉터리입니다.");
        }
    }

    private static void createDirectory(String directoryName) {
        File newDirectory = new File(currentDirectory, directoryName);

        if (newDirectory.mkdir()) {
            System.out.println("새로운 디렉터리 생성 성공!");
        } else {
            System.out.println("디렉터리 생성 실패.");
        }
    }
}
</pre>
