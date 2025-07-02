package com.business.br.service;

import org.springframework.stereotype.Service;

import com.business.br.entity.Role;
import com.business.br.repository.RoleRepository;

@Service
public class RoleService {
	
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role createRole(Role role) {
		Role tempRole = new Role();
		tempRole.setRoleName(role.getRoleName());
		tempRole.setRoleDesc(role.getRoleDesc());
		return roleRepository.save(tempRole);
		
	}

}
