package model.common;

import java.util.regex.Pattern;

public class Phone {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{11}$");
    private final String phone;

    public Phone(String phone) throws Exception {
        validate(phone);
        this.phone = phone;
    }

    private void validate(String phone) throws Exception {
        if (PHONE_PATTERN.matcher(phone).matches() == false)
            throw new Exception("Invalid phone format. Expected 11 digits.");
    }

    public String getPhone() {
        return phone;
    }
}
