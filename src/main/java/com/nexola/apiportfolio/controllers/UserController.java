package com.nexola.apiportfolio.controllers;

import com.nexola.apiportfolio.models.dto.PortfolioDTO;
import com.nexola.apiportfolio.models.dto.UserDTO;
import com.nexola.apiportfolio.models.dto.UserMinDTO;
import com.nexola.apiportfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/{id}/portfolio")
    public ResponseEntity<PortfolioDTO> getUserPortfolio(@PathVariable String id) {
        PortfolioDTO result = service.getUserPortfolio(id);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserMinDTO> getMe () {
        UserMinDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
