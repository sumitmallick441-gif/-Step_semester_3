class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String name) {
        String[] parts = name.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
