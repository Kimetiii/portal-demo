package com.example.portalback.sys.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootTest
class AccountModelTest {
    
    @Test
    void name() {
        AccountModel model = new AccountModel();
        model.setUsername("aa");
        model.setPassword("aa");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<AccountModel>> validate = validator.validate(model);

        System.out.println(1);


    }
}
