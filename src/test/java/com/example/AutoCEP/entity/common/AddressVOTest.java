package com.example.AutoCEP.entity.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressVOTest {

    @Test
    public void shouldCreateValidAddress() throws Exception {
        AddressVO address = new AddressVO("Rua Exemplo", "100", "Apt 2", "01001000",
                                "Centro" ,"São Paulo", "SP");

        assertEquals("Rua Exemplo", address.getStreetAddres());
        assertEquals("100", address.getNumber());
        assertEquals("Apt 2", address.getComplement());
        assertEquals("01001000", address.getCep());
        assertEquals("Centro", address.getNeighborhood());
        assertEquals("São Paulo", address.getCity());
        assertEquals("SP", address.getState());
    }

    @Test
    public void shouldAcceptBlankComplement() throws Exception {
        AddressVO address = new AddressVO("Rua Exemplo", "100", "", "01001000",
                "Centro" ,"São Paulo", "SP");

        assertEquals("", address.getComplement());
    }
}
