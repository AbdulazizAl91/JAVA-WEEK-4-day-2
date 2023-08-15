package com.example.usystem.Controller;

import com.example.usystem.ApiResponse.ApiResponse;
import com.example.usystem.Model.User;
import com.example.usystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String mesaage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(mesaage));
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id,@RequestBody @ Valid User user,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= userService.updateUsers(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("user not fonded"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body("user not founded");

    }
}
