/**
 * 
 */
package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.User;

/**
 * @author Veljko
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
