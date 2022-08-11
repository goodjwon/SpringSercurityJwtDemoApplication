package com.example.security.jwt.api;

import com.example.security.jwt.domain.Role;
import com.example.security.jwt.domain.User;
import com.example.security.jwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController @RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.created(makeUri("/api/user/save")).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.created(makeUri("/api/role/save")).body(userService.saveRole(role));
    }

    @PostMapping("/role/user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm from){
        userService.addRoleToUser(from.getUserName(), from.getRoleName());
        return ResponseEntity.ok().build();
    }

    private URI makeUri(String url){
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(url).toUriString());
    }
}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}
