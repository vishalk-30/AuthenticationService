package org.scaler.userloginservice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncoder implements PasswordEncoder {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public Boolean match(String password, String hashedPassword) {
        return bCryptPasswordEncoder.matches(password,hashedPassword);
    }
}
