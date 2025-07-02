package com.business.br.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.br.entity.Role;
import com.business.br.service.RoleService;

@RestController
@RequestMapping("api/")
public class BrController {
	
	private RoleService roleService;
	
	public BrController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	
	@GetMapping("hello")
	public String hello() {
		return "Hello";
	}
	
	
	@PostMapping("addRole")
	public ResponseEntity<?> addRole(@RequestBody Role role){
		return ResponseEntity.ok(roleService.createRole(role));
	}
}
