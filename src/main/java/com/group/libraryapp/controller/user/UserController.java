package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
    private final UserServiceV1 userServiceV1;
//    private final JdbcTemplate jdbcTemplate;

    public UserController(UserServiceV1 userServiceV1) {
//        this.jdbcTemplate = jdbcTemplate;
        this.userServiceV1 = userServiceV1;
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
        userServiceV1.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;

        return userServiceV1.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userServiceV1.updateUser(request);

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
       userServiceV1.deleteUser(name);
    }

}
