package model;

import model.common.Address;
import model.common.Cpf;
import model.common.Email;
import model.common.Phone;

import java.util.Date;

public class User {
    private final String name;
    private final String lastName;
    private final Email email;
    private final Date birthDate;
    private final Cpf cpf;
    private final Phone phone;
    private final Address address;

    public User(String name, String lastName, Email email, Date birthDate, Cpf cpf, Phone phone, Address address) throws Exception {

        if (name == null || name.isBlank()) throw new Exception("Name cannot be null or blank.");
        if (lastName == null || lastName.isBlank()) throw new Exception("Lastname cannot be null or blank.");
        if (email == null) throw new Exception("Email cannot be null.");
        if (birthDate == null) throw new Exception("Birth Date cannot be null.");
        if (birthDate.after(new Date())) throw new Exception("Birth date cannot be in the future.");
        if (cpf == null) throw new Exception("CPF cannot be null.");
        if (phone == null) throw new Exception("Phone cannot be null.");
        if (address == null) throw new Exception("Address cannot be null.");

        this.name = name.trim();
        this.lastName = lastName.trim();
        this.email = email;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

}
