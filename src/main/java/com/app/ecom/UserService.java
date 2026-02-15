package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
   /* private List<User> userList = new ArrayList<>();
    private Long id =1L;*/

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }
    public void addUser( User user){
        userRepository.save(user);
    }

    public Optional<User> fetchUser(Long id) {
//        for (User user : userList)
//        {
//            if (user.getId().equals(id)) {
//                return user;
//            }
//        }
//        return null;
       // return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
       return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User userUpdated) {
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst()
//                .map(existingUser -> {
//                    existingUser.setFirstName(userUpdated.getFirstName());
//                    existingUser.setLastName(userUpdated.getLastName());
//                    return true;
//                }).orElse(false);
        return userRepository.findById(id).map( existingUser -> {
            existingUser.setFirstName(userUpdated.getFirstName());
            existingUser.setLastName(userUpdated.getLastName());
            userRepository.save(existingUser);
            return true;
        }).orElse(false);
    }
}
