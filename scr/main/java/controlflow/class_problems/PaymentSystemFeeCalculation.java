import java.util.Scanner;

class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    double getAmount() {
        return amount;
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double getAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double getAmount() {
        return amount * 1.01;
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p;

            if (type.equals("CARD"))
                p = new CardPayment(amount);
            else if (type.equals("WALLET"))
                p = new WalletPayment(amount);
            else
                p = new BankTransfer(amount);

            double result = p.getAmount();

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
