import java.util.Scanner;

class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    double getFinalAmount() {
        return amount;
    }
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double getFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer c;

            if (type.equals("STUDENT"))
                c = new Student(amount);
            else if (type.equals("STAFF"))
                c = new Staff(amount);
            else
                c = new Guest(amount);

            double finalAmount = c.getFinalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
