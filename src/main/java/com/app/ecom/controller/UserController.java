package com.app.ecom.controller;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //This will generate constructor only for final fields.
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //ResponseEntity to have better control over response code.
    @GetMapping("/{id}")
    //@RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
//        User user = userService.fetchUser(id);
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);
        return userService.fetchUser(id)
                //.map(user -> ResponseEntity.ok(user))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
       userService.addUser(userRequest);
       return new ResponseEntity<>("User has been added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUserRequest){
        boolean updated = userService.updateUser(id, updatedUserRequest);
        if (updated) {
            return ResponseEntity.ok("User has been updated successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
