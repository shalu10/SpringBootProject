package com.food.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.Book;
import com.food.entity.Student;
import com.food.entity.User;
import com.food.repository.BookRepository;
import com.food.repository.StudentRepository;
import com.food.repository.UserRepository;

@RestController
@RequestMapping("/user")

//@CrossOrigin("http://localhost:5173")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	StudentRepository studeRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user)
	
	{
		User u = userRepo.save(user);
		return ResponseEntity.status(HttpStatus.OK)
				.body(u);
		
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUser()
	{
		List<User> u = userRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK)
				.body(u);
		
	}
	
	@GetMapping("/getById/{id}")
	
	public ResponseEntity<?> getById(@PathVariable int id)
	{
		User u =userRepo.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK)
				.body(u);
		
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable int id)
	
	{
		User u = userRepo.findById(id).get();
		u.setUserName(user.getUserName());
		u.setEmail(user.getEmail());
		userRepo.save(u);
		return ResponseEntity.status(HttpStatus.OK)
				.body(u);
		
		
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id)
	{
		userRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body("delete Successfully");
		
	}
	
//	@GetMapping("/getByAddress/{id}")
//	
//		public ResponseEntity<?> get(@PathVariable int id)
//		{
//			userRepo.getAddressData(id);
//			return ResponseEntity.status(HttpStatus.OK)
//					.body("delete Successfully");
//			
//		}
//	
	
	@PostMapping("/add/{bId}")
	public ResponseEntity<?> addStudent(@RequestBody Student s,@PathVariable int bId)
	
	{
		Book bk = bookRepo.findById(bId).get();
		
		s.setBook(bk);
		Student stud = studeRepo.save(s);
		return ResponseEntity.status(HttpStatus.OK)
				.body(stud);
		
		
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody Book b)
	
	{
		Book bk = bookRepo.save(b);
		return ResponseEntity.status(HttpStatus.OK)
				.body(bk);
		
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOwner(@PathVariable int id){
		Book book = bookRepo.findById(id).get();

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(book);
	}

	
	


}
