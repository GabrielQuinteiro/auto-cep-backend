package com.example.AutoCEP.model.common;

import model.common.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    public void shouldCreateValidEmail() throws Exception {
        Email email = new Email("teste@email.com");
        assertEquals("teste@email.com", email.getValue());
    }

    @Test
    public void shouldTrhowExceptionForInvalidEmail() {
        assertThrows(Exception.class, () -> new Email("teste"));
    }

    @Test
    public void shouldRejectEmailWithoutAtSymbol() {
        assertThrows(Exception.class, () -> new Email("teste.com"));
    }

    @Test
    public void shouldRejectNullEmail() {
        assertThrows(Exception.class, () -> new Email(null));
    }

    @Test
    public void shouldRejectEmptyEmail() {
        assertThrows(Exception.class, () -> new Email(""));
    }
}
