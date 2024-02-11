package org.scaler.userloginservice.service;

import lombok.AllArgsConstructor;
import org.scaler.userloginservice.dtos.CreateUserDto;
import org.scaler.userloginservice.dtos.LoginDto;
import org.scaler.userloginservice.dtos.ResponseUserDto;
import org.scaler.userloginservice.exception.IncorrectPasswordException;
import org.scaler.userloginservice.exception.InvalidEmailException;
import org.scaler.userloginservice.exception.UserAlreadyAvailableException;
import org.scaler.userloginservice.models.User;
import org.scaler.userloginservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptEncoder bCryptEncoder;

    public ResponseUserDto createUser(CreateUserDto createUserDto){
        String email = createUserDto.getEmail();

        if(emailValidation(email)){
            throw new InvalidEmailException("Email is not Valid");
        }
        if(userRepository.findUserByEmail(email) != null){
            throw new UserAlreadyAvailableException("This Email is already registered");
        }

        String hashedPassword = bCryptEncoder.encode(createUserDto.getPassword());

        User user = User.builder()
                .email(email)
                .password(hashedPassword)
                .name(createUserDto.getName())
                .build();

        user =  userRepository.save(user);
        return getResponseUserDtoFromUser(user);
    }

    private boolean emailValidation(String dtoEmail) {
        long cnt = dtoEmail.chars().filter(ch -> ch == '@').count();
        return cnt > 1;
    }

    private ResponseUserDto getResponseUserDtoFromUser(User user){
        return ResponseUserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .build();
    }


    public String login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        User user = userRepository.findUserByEmail(email);
        if(bCryptEncoder.match(loginDto.getPassword(), user.getPassword())){
            return "login Successfully";
        }throw new IncorrectPasswordException("Password Incorrect: Please try again");
    }
}
