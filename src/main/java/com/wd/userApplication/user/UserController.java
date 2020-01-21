package com.wd.userApplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("status")
    public String status(){
        return "{\"status\":\"web service is up !\"}";
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody(required = true) User user){

        userService.registerUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        List<User> userList=userService.getAllUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);

    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value="userId") Integer userId){

       User user=userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public  ResponseEntity deleteUser(@PathVariable(value = "userId") Integer userId){

        userService.deleteUser(userId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable(value = "userId") Integer userId, @RequestBody(required = true) User user){

        userService.updateUser(userId,user);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping("uploadfile")
    public ResponseEntity uploadFile(@PathParam("file") MultipartFile file) throws IOException{
        userService.readFile(file);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAll(){
        userService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

}
































