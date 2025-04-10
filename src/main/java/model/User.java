package model;

import model.common.Address;
import model.common.Cpf;
import model.common.Email;
import model.common.Phone;

import java.util.Date;

public class User {
    private String name;
    private String lastName;
    private Email email;
    private Date birthDate;
    private Cpf cpf;
    private Address address;
    private Phone phone;

    public User(String name, String lastName, Date birthDate, Cpf cpf, Address address, Phone phone) {
        this.name = name;
        this.lastName = lastName;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
