package com.example.AutoCEP.entity;

import com.example.AutoCEP.entity.common.AddressVO;
import com.example.AutoCEP.entity.common.CpfVO;
import com.example.AutoCEP.entity.common.PhoneVO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 100, message = "Lastname must be between 2 and 100 characters.")
    @Column(length = 100, nullable = false)
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @PastOrPresent
    private Date birthDate;

    @Embedded
    private CpfVO cpf;

    @Embedded
    private PhoneVO phone;

    @Embedded
    private AddressVO address;

    protected User() {
    }

    public User(UUID id, String name, String lastName, String email, Date birthDate, CpfVO cpf, PhoneVO phone, AddressVO address) {
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

    public String getEmail() {
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
