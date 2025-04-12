package com.example.AutoCEP.model.common;

import com.example.AutoCEP.exepction.phone.InvalidPhoneException;
import com.example.AutoCEP.exepction.phone.PhoneErrorCode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class PhoneVO {

    @Pattern(regexp = "^\\d{11}$")
    @Column()
    private String phone;

    public PhoneVO() {
    }

    public PhoneVO(String phone) throws InvalidPhoneException {
        validate(phone);
        this.phone = phone;
    }

    public void validate(String phone) throws InvalidPhoneException {
        String ddd = phone.substring(0, 2);
        if (DDD.isValid(ddd) == false) {
            throw new InvalidPhoneException(PhoneErrorCode.INVALID_DDD);
        }
    }

    public String getValue() {
        return phone;
    }
}
