package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domen.dto.CrendenciaisDTO;
import org.soulcodeacademy.helpr.domen.dto.TokenDTO;
import org.soulcodeacademy.helpr.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;
    @PostMapping("/auth/login")
    public TokenDTO login(@Valid @RequestBody CrendenciaisDTO dto){
        return this.service.login(dto);
    }
}
