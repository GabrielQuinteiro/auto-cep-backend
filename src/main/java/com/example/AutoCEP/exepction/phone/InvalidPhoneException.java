package com.example.AutoCEP.exepction.phone;

public class InvalidPhoneException extends Throwable {

    private final PhoneErrorCode code;

    public InvalidPhoneException(PhoneErrorCode code) {
        super(getMessageForCode(code));
        this.code = code;
    }

    private static String getMessageForCode(PhoneErrorCode code) {
        return "Invalid DDD.";
    }

    public PhoneErrorCode getCode() {
        return code;
    }
}
