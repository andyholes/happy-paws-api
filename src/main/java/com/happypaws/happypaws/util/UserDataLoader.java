package com.happypaws.happypaws.util;

import com.happypaws.happypaws.security.model.Role;
import com.happypaws.happypaws.security.model.RolesEnum;
import com.happypaws.happypaws.security.model.User;
import com.happypaws.happypaws.security.repository.RoleRepository;
import com.happypaws.happypaws.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) {
        loadUserData();
    }

    private void loadUserData() {

        //ROLES
        if (roleRepository.findAll().isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(RolesEnum.ROLE_ADMIN);
            roleRepository.save(adminRole);
            Role userRole = new Role();
            userRole.setName(RolesEnum.ROLE_USER);
            roleRepository.save(userRole);
        }


        //ADMIN USERS
        if (userRepository.findAll().isEmpty()) {
            User admin1 = User.builder()
                    .username("andyholes")
                    .email("andyholesdev@gmail.com")
                    .password(encoder.encode("password"))
                    .roles(new HashSet<>(Arrays.asList(roleRepository.findByName(RolesEnum.ROLE_ADMIN).get())))
                    .build();
            userRepository.save(admin1);
        }
    }
}
