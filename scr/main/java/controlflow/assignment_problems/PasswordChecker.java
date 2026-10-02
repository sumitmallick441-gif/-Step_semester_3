class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6)
            return "Weak";
        else if (password.length() < 10)
            return "Medium";
        else
            return "Strong";
    }
}
