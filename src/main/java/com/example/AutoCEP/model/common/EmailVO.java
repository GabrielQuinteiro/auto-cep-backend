package com.example.AutoCEP.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;

@Embeddable
public class EmailVO {

    @Email
    private String email;

    protected EmailVO() {
    }

    public EmailVO(String email) {
        this.email = email;
    }

    public String getValue() {
        return email;
    }
}
