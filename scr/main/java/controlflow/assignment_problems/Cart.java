class Cart {
    private double[] prices;
    private int count;
    private final String id;

    Cart(String id, int size) {
        this.id = id;
        prices = new double[size];
    }

    void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++)
            total += prices[i];

        return total;
    }

    int getItemCount() {
        return count;
    }
}
