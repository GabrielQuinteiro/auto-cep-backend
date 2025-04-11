package com.example.AutoCEP.model.common;

import model.common.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CpfTest {

    @Test
    public void shouldCreateValidCpf() throws Exception {
        Cpf cpf = new Cpf("390.533.447-05");
        assertEquals("39053344705", cpf.getValue());
    }

    @Test
    public void shouldCreateValidRawCpf() throws Exception {
        Cpf cpf = new Cpf("39053344705");
        assertEquals("39053344705", cpf.getValue());
    }

    @Test
    public void shouldThrowExcepetionForInvalidCpf() {
        assertThrows(Exception.class, () -> new Cpf("123.456.789-00"));
    }

    @Test
    public void shouldThrowExceptionForWrongLength() {
        assertThrows(Exception.class, () -> new Cpf("123456"));
    }

    @Test
    public void shouldThrowExceptionForAllDigitsEquals() {
        assertThrows(Exception.class, () -> new Cpf("111.111.111-11"));
    }
}
