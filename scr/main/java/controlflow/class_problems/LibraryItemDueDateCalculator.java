import java.time.LocalDate;
import java.util.Scanner;

class LibraryItem {
    String title;
    LocalDate date;

    LibraryItem(String title) {
        this.title = title;
        date = LocalDate.of(2023, 10, 26);
    }

    LocalDate getDueDate() {
        return date;
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return date.plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return date.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return date.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int first = line.indexOf(" ");
            String type = line.substring(0, first);
            String title = line.substring(first + 1).replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK"))
                item = new Book(title);
            else if (type.equals("DVD"))
                item = new DVD(title);
            else
                item = new Magazine(title);

            System.out.println(title + ": " + item.getDueDate());
        }
    }
}
