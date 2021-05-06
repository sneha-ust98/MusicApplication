package com.stackroute.JWTAuthentication.Service;


import com.stackroute.JWTAuthentication.Exception.UserAlreadyExistsException;
import com.stackroute.JWTAuthentication.Exception.UserNotFoundException;
import com.stackroute.JWTAuthentication.Model.User;
import com.stackroute.JWTAuthentication.Repository.UserRepository;
import com.stackroute.JWTAuthentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Value("${app.service.message1}")
    private String message1;

    @Value("${app.service.message2}")
    private String message2;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {

        Optional<User> userResult = userRepository.findById(user.getId());

        if (userResult.isPresent()) {
            throw new UserAlreadyExistsException(message1);
        }

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setPhoneNo(user.getPhoneNo());

        return userRepository.save(newUser);
    }

    @Override
    public User findByIdandPassword(String id, String password) throws UserNotFoundException {
        String encodedPassword = passwordEncoder.encode(password);
        User authUser = userRepository.findById(id).get();
        if (!passwordEncoder.matches(password, authUser.getPassword())) {
            throw new UserNotFoundException(message2);
        }

        return authUser;
    }


}




