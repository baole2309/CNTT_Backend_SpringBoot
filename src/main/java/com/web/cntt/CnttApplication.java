package com.web.cntt;

import com.web.cntt.model.Role;
import com.web.cntt.model.User;
import com.web.cntt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class CnttApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnttApplication.class, args);
    }
    @Bean
    CommandLineRunner run(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            String email = "19130015@st.hcmuaf.edu.vn";
            if(userRepository.findUserByEmail(email) == null) {
                userRepository.save(new User(UUID.randomUUID(), "admin", "admin", passwordEncoder.encode("12345678"), "19130015@st.hcmuaf.edu.vn", Role.ADMIN));
            }else {
                System.out.println("Người dùng đã tồn tại. Không tạo mới.");
            }
        };
    }
}
