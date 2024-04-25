package com.food.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.food.dto.ProductDto;
import com.food.entity.Product;
import com.food.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
     ProductRepository productRepo;

    @Autowired
    Environment env;

@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@ModelAttribute Product dto ,@RequestParam("file") MultipartFile uploadedFile) throws IOException {
		
		
			byte[] bytes = uploadedFile.getBytes();
			String fileLocation = "/home/dexter/ProjectFolder/SpringProject/FoodCart/src/main/resources/images/" + uploadedFile.getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);

			File file = new File(fileLocation);
			Product product = new Product();
			product.setName(dto.getName());
			product.setDescription(dto.getDescription());
			product.setPrice(dto.getPrice());
			product.setImage(file.getName());
			productRepo.save(product);
			return ResponseEntity.status(HttpStatus.OK).body(file.getName());
	}

	@GetMapping("/getProduct")
	public List<Product> getMethodName() {
		return productRepo.findAll();
	}
	
}
