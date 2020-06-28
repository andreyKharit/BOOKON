package com.itacademy.ankhar.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BootApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt(11)));
        System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt(11)));
        System.out.println(Long.parseLong("36"));
    }

}
