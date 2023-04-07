package com.latihanLsp.Controller;

import com.latihanLsp.Auth.JwtTokenUtil;
import com.latihanLsp.Model.Product;
import com.latihanLsp.Model.User;
import com.latihanLsp.Model.UserLogin;
import com.latihanLsp.RepoImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserImpl userImpl;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLogin user) {
//        UserLogin userLogin = new UserLogin(user.getUsername(), user.getPassword());

        User authenticatedUser = userImpl.findByUsername(user.getUsername());
        if (authenticatedUser == null || !authenticatedUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtTokenUtil.generateToken(authenticatedUser);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("role", authenticatedUser.getRole());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userImpl.save(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllAccount() {
        List<User> users = userImpl.getAllAccount();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userImpl.updatePassword(user);
        return ResponseEntity.ok().build();
    }
}
