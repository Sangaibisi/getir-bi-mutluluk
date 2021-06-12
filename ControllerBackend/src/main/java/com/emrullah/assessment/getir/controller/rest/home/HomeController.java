package com.emrullah.assessment.getir.controller.rest.home;

import com.emrullah.assessment.getir.base.dto.auth.AuthRequest;
import com.emrullah.assessment.getir.base.dto.user.CreateUserRequest;
import com.emrullah.assessment.getir.base.framework.GenericResponse;
import com.emrullah.assessment.getir.base.service.IUserService;
import com.emrullah.assessment.getir.base.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private IUserService _userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService authUserDetailsService;

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(new GenericResponse<>("Everything is okay"));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) {
        _userService.createUser(request);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
            );

            final UserDetails userDetails = authUserDetailsService.loadUserByUsername(req.getEmail());
            final String jwt = JwtUtil.generateToken(userDetails);

            HashMap<String, String> response = new HashMap<>();
            response.put("access_token", jwt);

            return ResponseEntity.ok().body(new GenericResponse<>("", response));
        }
        catch (BadCredentialsException | UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericResponse<>(4001, "Email or Password invalid"));
        }
    }

}
