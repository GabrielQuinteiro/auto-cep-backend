package com.example.AutoCEP.exepction.phone;

public class InvalidPhoneException extends Throwable {

    public InvalidPhoneException(PhoneErrorCode code) {

    }

    private static String getMessageForCode(PhoneErrorCode code) {
        return "Invalid DDD.";
    }
}
