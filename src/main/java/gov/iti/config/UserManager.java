package gov.iti.config;


import gov.iti.entity.User;
import gov.iti.mappers.UserMapper;
import gov.iti.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;


    public User createUser(User userDetails) throws Exception {

        User user = (User) userDetails;
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user  = userRepository.save(user);
        return user;
    }

}
