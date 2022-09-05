package com.medplus.tourmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medplus.tourmanagement.entities.UserLogin;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, Integer> {

	@Query(value = "select max(userId) from UserLogin")
	int getMaxUserId();
}
