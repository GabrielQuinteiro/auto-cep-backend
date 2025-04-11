package com.example.AutoCEP.model.common;

import model.common.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest {

    @Test
    public void shouldCreateValidPhone() throws Exception {
        Phone phone = new Phone("11997178755");
        assertEquals("11997178755", phone.getValue());
    }

    @Test
    public void shoulRejectInvalidPhoneNumber() {
        assertThrows(Exception.class, () -> new Phone("123456"));
    }
}
