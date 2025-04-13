package com.example.AutoCEP.entity.common;

import com.example.AutoCEP.exepction.cpf.CpfErrorCode;
import com.example.AutoCEP.exepction.cpf.InvalidCpfExecption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CpfVOTest {

    @Test
    public void shouldCreateValidCpf() {
        CpfVO cpf = new CpfVO("390.533.447-05");
        assertEquals("39053344705", cpf.getValue());
    }

    @Test
    public void shouldCreateValidRawCpf() {
        CpfVO cpf = new CpfVO("39053344705");
        assertEquals("39053344705", cpf.getValue());
    }

    @Test
    public void shouldThrowExceptionForInvalidCpfDigits() {
        InvalidCpfExecption exception = assertThrows(
                InvalidCpfExecption.class,
                () -> new CpfVO("123.456.789-00")
        );

        assertEquals(CpfErrorCode.INVALID_VERF_DIGITS, exception.getCode());
        assertEquals("CPF check digits do not match.", exception.getMessage());
    }
}
