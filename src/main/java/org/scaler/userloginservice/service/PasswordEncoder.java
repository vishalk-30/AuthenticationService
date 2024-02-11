package org.scaler.userloginservice.service;

public interface PasswordEncoder {

    String encode(String password);
    Boolean match(String password,String hashedPassword);
}
