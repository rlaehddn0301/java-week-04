package Report;

public class SubjectScore {
    public static void main(String[] args) {
        String[] subjects = {"국어", "영어", "수학", "과학", "역사"};
        int[] scores = {95, 88, 76, 62, 55};

        // 배열 출력
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + scores[i]);
        }
    }
}

