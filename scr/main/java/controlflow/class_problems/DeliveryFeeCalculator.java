import java.util.Scanner;

class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    double getFee() {
        return 0;
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double getFee() {
        return 5 + weight * 0.5 + distance * 0.1;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double getFee() {
        return 15 + weight + distance * 0.2;
    }
}

class InternationalDelivery extends Delivery {
    double customs;

    InternationalDelivery(double weight, double distance, double customs) {
        super(weight, distance);
        this.customs = customs;
    }

    double getFee() {
        return 25 + weight * 2 + distance * 0.5 + customs;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery d;

            if (type.equals("STANDARD"))
                d = new StandardDelivery(weight, distance);
            else if (type.equals("EXPRESS"))
                d = new ExpressDelivery(weight, distance);
            else {
                double customs = sc.nextDouble();
                d = new InternationalDelivery(weight, distance, customs);
            }

            double fee = d.getFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
