package com.example.AutoCEP.exepction.cpf;

public class InvalidCpfExecption extends RuntimeException {

    private final CpfErrorCode code;

    public InvalidCpfExecption(CpfErrorCode code) {
        super(getMessageForCode(code));
        this.code = code;
    }

    private static String getMessageForCode(CpfErrorCode code) {
        return switch (code) {
            case ALL_DIGITS_EQUALS -> "CPF cannot have all digits equal.";
            case INVALID_VERF_DIGITS -> "CPF check digits do not match.";
        };
    }

    public CpfErrorCode getCode() {
        return code;
    }
}
