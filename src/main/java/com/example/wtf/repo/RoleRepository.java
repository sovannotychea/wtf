/**
 * 
 */
package com.example.wtf.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wtf.model.Role;

/**
 * @author sovannoty
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}