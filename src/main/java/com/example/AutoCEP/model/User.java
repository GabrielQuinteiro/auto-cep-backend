package com.example.AutoCEP.model;

import com.example.AutoCEP.model.common.AddressVO;
import com.example.AutoCEP.model.common.CpfVO;
import com.example.AutoCEP.model.common.EmailVO;
import com.example.AutoCEP.model.common.PhoneVO;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastName;

    @Embedded
    private EmailVO email;
    private Date birthDate;

    @Embedded
    private CpfVO cpf;

    @Embedded
    private PhoneVO phone;

    @Embedded
    private AddressVO address;

    protected User() {
    }

    public User(UUID id, String name, String lastName, EmailVO email, Date birthDate, CpfVO cpf, PhoneVO phone, AddressVO address) {
        this.id = id;
        this.name = name.trim();
        this.lastName = lastName.trim();
        this.email = email;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailVO getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public CpfVO getCpf() {
        return cpf;
    }

    public AddressVO getAddress() {
        return address;
    }

    public PhoneVO getPhone() {
        return phone;
    }

}
