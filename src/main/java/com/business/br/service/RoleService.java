package com.business.br.service;

import org.springframework.stereotype.Service;

import com.business.br.dto.Response;
import com.business.br.entity.Role;
import com.business.br.exception.ResourceNotFoundException;
import com.business.br.projection.RoleProjection;
import com.business.br.repository.RoleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleService {

	private RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Response createRole(Role role) {
		Response response = new Response();
		Role tempRole = new Role();
		try {
			RoleProjection existingRole = roleRepository.findByRoleName(role.getRoleName());
			if (existingRole == null) {
				tempRole.setRoleName(role.getRoleName());
				tempRole.setRoleDesc(role.getRoleDesc());
				roleRepository.save(tempRole);
				response.setMessage("Added");
				response.setStatus(true);
				return response;
			} else {
				response.setMessage("Not created");
				response.setStatus(false);

			}
		} catch (ResourceNotFoundException e) {
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
