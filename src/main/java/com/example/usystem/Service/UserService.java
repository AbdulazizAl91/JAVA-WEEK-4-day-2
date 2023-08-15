package com.example.usystem.Service;

import com.example.usystem.Model.User;
import com.example.usystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void addUsers(User user){

        userRepository.save(user);
    }
    public boolean updateUsers(Integer id,User users){
        User oldUsers = userRepository.getById(id);
        if (oldUsers == null){
            return false;
        }
        oldUsers.setName(users.getName());
        oldUsers.setUsername(users.getUsername());
        oldUsers.setPassword(users.getPassword());
        oldUsers.setRole(users.getRole());
        oldUsers.setAge(users.getAge());
        userRepository.save(oldUsers);
        return true;
    }
    public boolean deleteUser(Integer id){
        User oldUsers =userRepository.getById(id);
        if (oldUsers!= null){
            userRepository.delete(oldUsers);
            return true;
        }
        return false;
    }


}
