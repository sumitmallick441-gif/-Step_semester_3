import java.util.Scanner;

class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    double getScore() {
        return 0;
    }
}

class MCQ extends Question {
    MCQ(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double getScore() {
        if (answer.equalsIgnoreCase(correct))
            return points;
        return 0;
    }
}

class TF extends Question {
    TF(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double getScore() {
        if (answer.equalsIgnoreCase(correct))
            return points;
        return 0;
    }
}

class Essay extends Question {
    Essay(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double getScore() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String word : keywords) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim().split(" ")[0];
            String correct = parts[3];
            String answer = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(correct, answer, points);
            else if (type.equals("TF"))
                q = new TF(correct, answer, points);
            else
                q = new Essay(correct, answer, points);

            double score = q.getScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
