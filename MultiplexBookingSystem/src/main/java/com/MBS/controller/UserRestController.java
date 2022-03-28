package com.MBS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MBS.model.User;
import com.MBS.service.UserService;


@RestController
@RequestMapping("/Users")

public class UserRestController {

	@Autowired
	UserService service;

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User a) {
		try {
			return new ResponseEntity<String>(service.addUser(a), HttpStatus.OK);


		}catch(Exception e) {
			return new ResponseEntity<String>("Something went wrong, try again", HttpStatus.OK);
		}

	}
	
}

