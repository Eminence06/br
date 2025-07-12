package com.business.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.br.entity.Role;
import com.business.br.projection.RoleProjection;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	RoleProjection findByRoleName(String name);

}
