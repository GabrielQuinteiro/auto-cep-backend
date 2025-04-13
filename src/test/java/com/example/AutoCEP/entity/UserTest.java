package com.example.AutoCEP.entity;

import com.example.AutoCEP.exepction.cpf.InvalidCpfExecption;
import com.example.AutoCEP.exepction.phone.InvalidPhoneException;
import com.example.AutoCEP.entity.common.AddressVO;
import com.example.AutoCEP.entity.common.CpfVO;
import com.example.AutoCEP.entity.common.PhoneVO;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static Validator validator;

    @BeforeAll
    static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldCreateValidUser() throws InvalidPhoneException, InvalidCpfExecption {

        User user = new User(
                null,
                "Teste",
                "Unitario",
                "teste@email.com",
                new Date(),
                new CpfVO("390.533.447-05"),
                new PhoneVO("11997178755"),
                new AddressVO("Rua Exemplo", "100", "Apt 2", "01001000",
                        "Centro" ,"São Paulo", "SP")
        );

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertTrue(violations.isEmpty(), "Should not be a validation violation.");
    }
}
