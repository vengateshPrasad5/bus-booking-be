package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Dto.*;
import com.busbookingbe.app.Entity.Role;
import com.busbookingbe.app.Entity.User;
import com.busbookingbe.app.Exception.CustomAPIException;
import com.busbookingbe.app.Respository.RoleRepository;
import com.busbookingbe.app.Respository.UserRepository;
import com.busbookingbe.app.Security.JwtUtil;
import com.busbookingbe.app.Service.AuthService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private ModelMapper modelMapper;

    @Override
    public String register(RegisterDTO registerDto) {
        // To check whether a user already exists with the same username
        if (userRepository.existsByUserName(registerDto.getUserName())) {
            throw new CustomAPIException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        // To check whether a user already exists with the same email
        if (userRepository.existsByEmailId(registerDto.getEmailId())) {
            throw new CustomAPIException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        // Creating a user from the DTO and to store in the user table
        User user = new User();
        user.setUserName(registerDto.getUserName());
        user.setEmailId(registerDto.getEmailId());
        user.setUserName(registerDto.getUserName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);
        return "User Registered Successfully!!";
    }

    @Override
    public JwtAuthResponse login(LoginRequestDTO loginRequestDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginRequestDto.getUsername(),
                loginRequestDto.getPassword()
        );
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generate(loginRequestDto.getUsername());

        Optional<User> userOptional = userRepository.findByEmailId(loginRequestDto.getUsername());
        String role = "";
        if (userOptional.isPresent()) {
            User loggedInUser = userOptional.get();
            Optional<Role> optionalRole = loggedInUser.getRoles().stream().findFirst();
            Role userRole = optionalRole.get();
            role = userRole.getName();
        }
    
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(jwt);
        jwtAuthResponse.setRole(role);
        jwtAuthResponse.setUserId(userOptional.get().getUserId());
        jwtAuthResponse.setUserName(userOptional.get().getUserName());

        return jwtAuthResponse;
    }

    @Override
    public UserProfileDTO getUser(String userName) {
        User user = userRepository.findByUserNameOrEmailId( userName,userName).get();
        return modelMapper.map(user,UserProfileDTO.class);
    }

    @Override
    public String changePassword(PwdChangeDTO pwdChangeDTO) {
        if (userRepository.existsByUserName(pwdChangeDTO.getUserName())) {
            throw new CustomAPIException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        Optional<User> optUser = userRepository.findByUserNameOrEmailId(pwdChangeDTO.getUserName(), pwdChangeDTO.getUserName());
        if(optUser.isPresent()){
            User user = optUser.get();
            if(!passwordEncoder.matches(pwdChangeDTO.getCurrentPwd(),user.getPassword())){
                throw new CustomAPIException(HttpStatus.BAD_REQUEST,"Current Password Invalid");
            }
            String newPassword  = passwordEncoder.encode(pwdChangeDTO.getNewPwd());
            user.setPassword(newPassword);
            userRepository.save(user);
        }
        return "Password Change Successfully";
    }
}
