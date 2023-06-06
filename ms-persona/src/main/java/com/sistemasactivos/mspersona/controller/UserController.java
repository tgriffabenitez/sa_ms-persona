package com.sistemasactivos.mspersona.controller;

import com.sistemasactivos.mspersona.model.User;
import com.sistemasactivos.mspersona.service.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserController extends BaseControllerImpl<User, UserServiceImpl> {
}
