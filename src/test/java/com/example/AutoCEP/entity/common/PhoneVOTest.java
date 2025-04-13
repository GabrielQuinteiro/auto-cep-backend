package com.example.AutoCEP.entity.common;

import com.example.AutoCEP.exepction.phone.InvalidPhoneException;
import com.example.AutoCEP.exepction.phone.PhoneErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneVOTest {

    @Test
    public void shouldCreateValidPhone() throws InvalidPhoneException {
        PhoneVO phone = new PhoneVO("11997178755");
        assertEquals("11997178755", phone.getValue());
    }

    @Test
    public void shouldNormalizePhoneNumber() throws InvalidPhoneException {
        PhoneVO phone = new PhoneVO("(11) 99717-8755");
        assertEquals("11997178755", phone.getValue());
    }

    @Test
    public void shoulRejectInvalidDDD() {
        InvalidPhoneException exception = assertThrows(
                InvalidPhoneException.class,
                () -> new PhoneVO("23123456789")
        );

        assertEquals(PhoneErrorCode.INVALID_DDD, exception.getCode());
        assertEquals("Invalid DDD.", exception.getMessage());
    }
}
