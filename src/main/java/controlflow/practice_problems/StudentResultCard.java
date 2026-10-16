
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / 3.0;
    }

    char grade() {
        double avg = average();

        if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else if (avg >= 40)
            return 'D';
        else
            return 'F';
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average(), grade());
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name1 = sc.next();
        int[] marks1 = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        String name2 = sc.next();
        int[] marks2 = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        Student s1 = new Student(name1, marks1);
        Student s2 = new Student(name2, marks2);

        s1.display();
        s2.display();
    }
}
