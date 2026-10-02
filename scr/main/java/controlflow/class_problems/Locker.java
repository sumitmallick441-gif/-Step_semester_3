class Locker {
    private String code;
    private final int number;

    Locker(int number, String code) {
        this.number = number;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode))
            code = newCode;
    }
}
