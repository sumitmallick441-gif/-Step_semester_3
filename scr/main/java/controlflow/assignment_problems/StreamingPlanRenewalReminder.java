import java.util.Scanner;
import java.time.LocalDate;

class Plan {
    LocalDate date;

    Plan(LocalDate date) {
        this.date = date;
    }

    LocalDate getRenewalDate() {
        return date;
    }
}

class Basic extends Plan {
    Basic(LocalDate date) {
        super(date);
    }

    LocalDate getRenewalDate() {
        return date.plusDays(30);
    }
}

class Standard extends Plan {
    Standard(LocalDate date) {
        super(date);
    }

    LocalDate getRenewalDate() {
        return date.plusDays(90);
    }
}

class Premium extends Plan {
    Premium(LocalDate date) {
        super(date);
    }

    LocalDate getRenewalDate() {
        return date.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(date);
            else if (type.equals("STANDARD"))
                p = new Standard(date);
            else
                p = new Premium(date);

            System.out.println(name + ": " + p.getRenewalDate());
        }
    }
}
