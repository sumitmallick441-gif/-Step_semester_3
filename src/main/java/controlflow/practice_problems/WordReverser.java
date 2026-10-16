
import java.util.Scanner;

public class WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();

        System.out.println(reverse + (word.equals(reverse) ? " - palindrome" : " - not a palindrome"));
    }
}
