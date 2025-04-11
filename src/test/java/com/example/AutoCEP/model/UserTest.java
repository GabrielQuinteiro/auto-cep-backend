package com.example.AutoCEP.model;

import model.User;
import model.common.Address;
import model.common.Cpf;
import model.common.Email;
import model.common.Phone;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void shouldCreateValidUser() throws Exception {
        Email email = new Email("teste@email.com");
        Cpf cpf = new Cpf("390.533.447-05");
        Phone phone = new Phone("11997178755");
        Address address = new Address("Rua Exemplo", "100", "Apt 2", "01001000",
                "Centro" ,"São Paulo", "SP");


        User user = new User(
                "Teste",
                "Unitario",
                email,
                new Date(),
                cpf,
                phone,
                address
        );

        assertNotNull(user);
        assertEquals("Teste", user.getName());
        assertEquals("Unitario", user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(cpf, user.getCpf());
        assertEquals(phone, user.getPhone());
        assertEquals(address, user.getAddress());
    }

    @Test
    public void shouldThrowsExceptionForInvalidUserBuild() throws Exception {
        Email email = new Email("teste@email.com");
        Cpf cpf = new Cpf("390.533.447-05");
        Phone phone = new Phone("11997178755");
        Address address = new Address("Rua Exemplo", "100", "Apt 2", "01001000",
                "Centro" ,"São Paulo", "SP");

        assertThrows(Exception.class, () -> new User(
                "",
                "",
                email,
                new Date(),
                cpf,
                phone,
                address
        ));
    }
}
