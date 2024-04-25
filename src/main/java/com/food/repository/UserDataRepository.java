package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.UserData;

public interface UserDataRepository extends JpaRepository<UserData,Integer>{

    
} 
