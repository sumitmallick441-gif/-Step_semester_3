import java.util.Scanner;

class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    double getFare() {
        return 0;
    }
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return Math.min(10, 2 + distance * 0.1);
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return 3 + distance * 0.15;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double distance, double factor) {
        super(distance);
        this.factor = factor;
    }

    double getFare() {
        return (1.5 + distance * 0.2) * factor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            if (type.equals("BUS"))
                t = new Bus(distance);
            else if (type.equals("TRAIN"))
                t = new Train(distance);
            else {
                double factor = sc.nextDouble();
                t = new Metro(distance, factor);
            }

            double fare = t.getFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
