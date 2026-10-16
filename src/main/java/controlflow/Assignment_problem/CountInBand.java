
public class CountInBand {
    static int countInBand(int[] scores, int low, int high) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low)
                left = mid + 1;
            else
                right = mid;
        }

        int first = left;
        left = 0;
        right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high)
                left = mid + 1;
            else
                right = mid;
        }

        return left - first;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low = 42;
        int high = 58;

        System.out.println(countInBand(scores, low, high));
    }
}
