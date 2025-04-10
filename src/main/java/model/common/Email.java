package model.common;

import java.util.regex.Pattern;

public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    private final String email;

    public Email(String email) throws Exception {
        validate(email);
        this.email = email;
    }

    public void validate(String email) throws Exception {
        if (EMAIL_PATTERN.matcher(email).matches() == false) {
            throw new Exception("Format email invalid.");
        }
    }

    public String getEmail() {
        return email;
    }
}
