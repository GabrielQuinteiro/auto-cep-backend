package com.example.AutoCEP.model.common;

import model.common.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddresTest {

    @Test
    public void shouldCreateValidAddress() throws Exception {
        Address address = new Address("Rua Exemplo", "100", "Apt 2", "01001000",
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
    public void shouldThrowExceptionForMissingState() {
        assertThrows(Exception.class, () -> new Address(
                "Rua X", "10", "Apt 2", "Bairro Y",
                "Cidade Z", "", "12345678"));
    }

    @Test
    public void shouldAcceptBlankComplement() throws Exception {
        Address address = new Address("Rua Exemplo", "100", "", "01001000",
                "Centro" ,"São Paulo", "SP");

        assertEquals("", address.getComplement());
    }

}
