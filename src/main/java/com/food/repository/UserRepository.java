package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
//	@Query(value="select * from users where addressId in (select addressId from users where addressId=?1")
//	User getAddressData(int id);

}
