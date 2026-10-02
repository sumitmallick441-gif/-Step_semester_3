class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int questions) {
        results = new boolean[questions];
    }

    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i])
                score++;
        }

        return score;
    }
}
