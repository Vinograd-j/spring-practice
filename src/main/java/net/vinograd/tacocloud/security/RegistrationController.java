package net.vinograd.tacocloud.security;

import net.vinograd.tacocloud.data.UserRepository;
import net.vinograd.tacocloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm registrationForm) {
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
