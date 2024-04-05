package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Book;

public interface BookRepository extends JpaRepository<Book , Integer>{

}
