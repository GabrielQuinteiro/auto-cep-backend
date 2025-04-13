package com.example.AutoCEP.entity.common;

import com.example.AutoCEP.exepction.phone.InvalidPhoneException;
import com.example.AutoCEP.exepction.phone.PhoneErrorCode;
import com.example.AutoCEP.entity.common.enums.DDD;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class PhoneVO {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{11}$")
    @Column(length = 11, nullable = false)
    private String phone;

    public PhoneVO() {
    }

    public PhoneVO(String phone) throws InvalidPhoneException {
        validate(phone);
        this.phone = normalize(phone);
    }

    private String normalize(String phone) {
        return phone.replaceAll("[^\\d]", "");
    }

    public void validate(String phone) throws InvalidPhoneException {
        String rawPhone = normalize(phone);

        String ddd = rawPhone.substring(0, 2);
        if (DDD.isValid(ddd) == false) {
            throw new InvalidPhoneException(PhoneErrorCode.INVALID_DDD);
        }
    }

    public String getValue() {
        return phone;
    }
}
